# Copyright (c) 2014 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

DESCRIPTION = "Provides file integrity checking and log file monitoring/analysis"
HOMEPAGE    = "http://www.la-samhna.de/samhain/"
LICENSE     = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ca43cbc842c2336e835926c2166c28b"
DEPENDS     = "postgresql"

inherit autotools-brokensep update-rc.d

INITSCRIPT_NAME = "samhain-${SAMHAIN_MODE}"
INITSCRIPT_PARAMS ?= "defaults"

SRC_URI = "http://la-samhna.de/archive/samhain_signed-${PV}.tar.gz \
	   file://${INITSCRIPT_NAME}.init \
	   file://${INITSCRIPT_NAME}.default \
	   file://samhain-cross-fixes.patch \
	   file://samhain-fixes-for-o32.patch \
	   file://fix-install-paths.patch \
	   file://use_stat_on_var_run.patch \
	  "


TARGET_CC_ARCH +="${LDFLAGS}"
S = "${WORKDIR}/samhain-${PV}"

# We have to unpack the tar ball twice to get to the source.
# Also as soon as OE gets the tar ball it unpacks and
# proceeds to apply the patches. But what you still have after
# the first unpack is another tar ball. So we do a do_unpack_extra()
# and tell OE to do the second unpack before do_patch(), otherwise
# do_patch() will fail when trying to apply the patches.
do_unpack_extra () {
	cd ${WORKDIR}
	tar -xzvf samhain-${PV}.tar.gz
}
addtask unpack_extra after do_unpack before do_patch

EXTRA_OECONF += "--enable-network=${SAMHAIN_MODE} \
		 --enable-suidcheck --enable-login-watch \
         --enable-mounts-check --enable-userfiles --enable-xml-log \
         --with-database=postgresql \
"

#do_configure_prepend() {
#	export sh_cv___va_copy=yes
#}

# If we use oe_runconf in do_configure() it will by default
# use the prefix --oldincludedir=/usr/include which is not
# recognized by Samhain's configure script and would invariably
# throw back the error "unrecognized option: --oldincludedir=/usr/include"
do_configure () {
        cd ${S}
	export PGSQL_HOME="${STAGING_INCDIR}"
	export PGSQL_LIB_DIR="${STAGING_LIBDIR}"
	./configure \
		    --build=${BUILD_SYS} \
		    --host=${HOST_SYS} \
		    --target=${TARGET_SYS} \
		    --prefix=${prefix} \
		    --exec_prefix=${exec_prefix} \
		    --bindir=${bindir} \
		    --sbindir=${sbindir} \
		    --libexecdir=${libexecdir} \
		    --datadir=${datadir} \
		    --sysconfdir=${sysconfdir} \
		    --sharedstatedir=${sharedstatedir} \
		    --localstatedir=${localstatedir} \
		    --libdir=${libdir} \
		    --includedir=${includedir} \
		    --infodir=${infodir} \
		    --mandir=${mandir} \
		    ${EXTRA_OECONF}
}

# Install the init script, it's default file, and the extraneous
# documentation.
do_install_append () {
    cd ${S}
	oe_runmake install DESTDIR='${D}' INSTALL=install-boot
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/${INITSCRIPT_NAME}.init \
		${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}

	install -d ${D}${sysconfdir}/default
	install -m 755 ${WORKDIR}/${INITSCRIPT_NAME}.default \
		${D}${sysconfdir}/default/${INITSCRIPT_NAME}

	install -d ${D}${docdir}/${PN}
	cp -r docs/* ${D}${docdir}/${PN}
	cp -r scripts ${D}${docdir}/${PN}
}

RDEPENDS_${PN} += "rpcbind vim"

SRC_URI[md5sum] = "f7fff913d016241eec6829bd5f740513"
SRC_URI[sha256sum] = "844e8e22c0e259b4c12cd0ccacdb3d5569a2a1746b0aa1aa285febb266cbcf31"
