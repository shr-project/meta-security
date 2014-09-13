SUMMARY = "ISIC -- IP Stack Integrity Checker"
DESCRIPTION = "ISIC is a suite of utilities to exercise the stability of an IP Stack and its component stacks (TCP, UDP, ICMP et. al.)"
SECTION = "security"
LICENSE = "BSD"
HOMEPAGE = "http://isic.sourceforge.net/"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

DEPENDS = "libnet"

SRC_URI = "http://prdownloads.sourceforge.net/isic/${BPN}-${PV}.tgz"

SRC_URI[md5sum] = "29f70c9bde9aa9128b8f7e66a315f9a4"
SRC_URI[sha256sum] = "e033c53e03e26a4c72b723e2a5a1c433ee70eb4d23a1ba0d7d7e14ee1a80429d"
inherit autotools

#S = "${WORKDIR}/${BPN}-${PV}"

EXTRA_OECONF += "ac_srcdir_defaulted=yes "

#do_configure () {
#}

#do_install () {
#    oe_runmakeinstall
#}

#REQUIRED_DISTRO_FEATURES ?=" tomoyo"
#RDEPEND += "systemd"
