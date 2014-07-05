DESCRIPTION = "wireshark - a popular network protocol analyzer"
HOMEPAGE = "http://www.wireshark.org"
SECTION = "network"
LICENSE = "GPL-2.0"
DEPENDS = "perl-native gnutls libpcap pcre expat glib-2.0 libsmi gtk+"

EXTRA_OECONF = "--enable-usr-local=no --enable-wireshark --enable-tshark" 

LIC_FILES_CHKSUM = "file://README.linux;md5=78a1c9d63c85d6c8004c16fd48570d54"

SRC_URI = "${SOURCEFORGE_MIRROR}/wireshark/wireshark-${PV}.tar.bz2"

SRC_URI[md5sum] = "510dc3b063785549b41ebc748ac21055"
SRC_URI[sha256sum]= "27d9cf4f0ca1ac436104b7f27caf8ad65f73db09edc8df0742ce9688c7d38763"

ARM_INSTRUCTION_SET = "arm"

inherit autotools-brokensep

do_compile_prepend() {
         find . -type f -name Makefile \
                -exec sed -e 's@-I/usr/include @@g' \
                          -e 's@-I$(includedir)@@g' \
                          -e 's@-I/usr/local/include @@g' \
                          -e "s@-I${includedir} @@g" -i '{}' ';'

         oe_runmake -C tools/lemon CC="${BUILD_CC} ${BUILD_CFLAGS}" \
         CC_FOR_BUILD="${BUILD_CC} ${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}"
}

