SUMMARY = "ClamAV anti-virus utility for Unix - command-line interface"
DESCRIPTION = "ClamAV is an open source antivirus engine for detecting trojans, viruses, malware & other malicious threats."
HOMEPAGE = "http://www.clamav.net/index.html"
SECTION = "security"
LICENSE = "LGPL-2.1"
DEPENDS = "libtool db openssl zlib ncurses bzip2"

LIC_FILES_CHKSUM = "file://COPYING.LGPL;beginline=2;endline=3;md5=4b89c05acc71195e9a06edfa2fa7d092"

SRC_URI = "${DEBIAN_MIRROR}/main/c/${BPN}/${BPN}_${PV}+dfsg.orig.tar.xz;name=archive \
    file://0001-Change-paths-in-sample-conf-file-to-match-Debian.patch \
    file://0002-Add-an-additional-n-after-the-number-in-the-pidfile.patch \
    file://0003-unit_tests-increment-test-timeout-from-40secs-to-5mi.patch \
    file://0004-Fix-compiling-on-Hurd.patch \
    file://0005-Workaround-a-bug-in-libc-on-Hurd.patch \
    file://0006-remove-unnecessary-harmful-flags-from-libclamav.pc.patch \
    file://0007-libclamav-use-libmspack.patch \
    file://0008-Add-upstream-systemd-support-for-clamav-daemon-and-c.patch \
    file://0009-fix-ssize_t-size_t-off_t-printf-modifier.patch \
    file://0010-hardcode-LLVM-linker-flag-because-llvm-config-return.patch \
    file://0011-Add-libmspack-library-from-upstream-without-unnecess.patch \
    file://0012-allow-to-use-internal-libmspack-if-the-external-is-n.patch \
    file://0013-fix-autoreconf-with-embedded-libmspack.patch \
    file://0014-remove-AC_CONFIG_SRCDIR-llvm-configure-from-libclama.patch \
    file://0015-bb-10731-Allow-to-specificy-a-group-for-the-socket-o.patch \
    file://0016-clamav-milter-add-additinal-SMFIF_-flags-before-invo.patch \
    file://0017-Bump-.so-version-number.patch \
    file://0018-llvm-don-t-use-system-libs.patch \
    file://clamav-0001-clamdscan.patch \
"

SRC_URI[archive.md5sum] = "34d5e8698e57ce45c4a8c3c2cb211cf3"
SRC_URI[archive.sha256sum] = "0e353f646a0add17ca42e75ccfc7edf4f8b7c1acc972a86c317543f6b365db2d"

inherit autotools-brokensep pkgconfig

S = "${WORKDIR}/${BPN}-${PV}+dfsg"

PACKAGECONFIG ??= ""
PACKAGECONFIG += " ${@bb.utils.contains("DISTRO_FEATURES", "ipv6", "ipv6", "", d)}"
PACKAGECONFIG[xml] = "--with-xml=${STAGING_LIBDIR}/.., --with-xml=no, libxml2,"
PACKAGECONFIG[json] = "--with-libjson=${STAGING_LIBDIR}, --without-libjson, json,"
PACKAGECONFIG[curl] = "--with-libcurl=${STAGING_LIBDIR}, --without-libcurl, curl,"
PACKAGECONFIG[ipv6] = "--enable-ipv6, --disable-ipv6"

UID = "clamav"
GID = "clamav"

EXTRA_OECONF += " --with-user=${UID}  --with-group=${GID} \
            --without-libcheck-prefix \
            --disable-unrar \
            --disable-llvm \
            --with-openssl=${STAGING_LIBDIR}/.. \
            --with-zlib=${STAGING_LIBDIR}/.. \
            --with-libbz2-prefix=${STAGING_DIR}${prefix} \
            --with-libcurses-prefix=${STAGING_LIBDIR}/.. \
"
RDEPENDS_${PN} += "openssl ncurses-libncurses libbz2 ncurses-libtinfo"
