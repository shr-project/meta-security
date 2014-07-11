SUMMARY = "Rootkit Scanner"
DESCRIPTION = "This tool scans for rootkits, backdoors and local exploits by running tests like: MD5 hash compare, look for default files used by rootkits, wrong file permissions for binaries, look for suspected strings in LKM and KLD modules, look for hidden files, and optional scan within plaintext and binary files."
SECTION = "security"
LICENSE = "GPL-2.0"
HOMEPAGE="http://rkhunter.sourceforge.net"

DEPENDS = " perl"
LIC_FILES_CHKSUM = "file://installer.sh;md5=282eec0d690271eead442fe22162530f"

SRC_URI = "http://downloads.sourceforge.net/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "85ad366b7f3999eb2a9371e39a1a4df7"
SRC_URI[sha256sum] = "789cc84a21faf669da81e648eead2e62654cfbe0b2d927119d8b1e55b22b65c3"

do_install (){
    ${S}/installer.sh --layout custom ${D} --install

}

#PACKAGES = "${PN}"

FILES_${PN} = "\
    /bin/* \
    /share/* \
    /var/* \
    /etc/* \
    /lib64/* \
    /lib/* \
    "
#${bindir}/* 
#${libdir}/* 
#${syscondir}/* 
#${mandir}/* 
#${docdir}/* 
#${localstatedir}/* 
#"
