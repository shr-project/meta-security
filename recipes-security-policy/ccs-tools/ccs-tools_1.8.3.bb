SUMMARY = "Tomoyo"
DESCRIPTION = ""
SECTION = "security"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://README.ccs;md5=5b80632c6a2a3b7fa92ea46eff15bee9"

DEPENDS = "ncurses"

SRC_URI = "http://osdn.dl.sourceforge.jp/tomoyo/49693/ccs-tools-1.8.3-20130406.tar.gz"

SRC_URI[md5sum] = "ffff535584cdf9ae28b85061c32e5618"
SRC_URI[sha256sum] = "1e4129b59cd7fdb963962af7f2cccf4a66c77a4b0948f67320b569aaf6585fcf"

S = "${WORKDIR}/${PN}"
do_make(){
    oe_runmake USRLIBDIR=${libdir} all
}

do_install(){
    oe_runmake INSTALLDIR=${D}  USRLIBDIR=${libdir} install
}

PACKAGE="${PN} ${PN}-dbg"

FILES_${PN} = "\
    /usr/sbin/* \
    /sbin/* \
    ${libdir}/* \
"

FILES_${PN}-dbg = "\
    /sbin/.debug/* \
    /usr/sbin/.debug/* \
    /usr/lib/.debug/* \
    ${libdir}/ccs/.debug/* \
    /usr/src/debug/* \
"


