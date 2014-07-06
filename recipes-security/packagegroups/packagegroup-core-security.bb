DESCRIPTION = "Security packagegroup for Poky"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit packagegroup

PACKAGES = "\
    packagegroup-security-scanners \
    packagegroup-security-utils \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_packagegroup-security-scanners = " \
    nikto \
    nmap \
	"
RDEPENDS_packagegroup-security-utils = " \
    pax-utils \
    libseccomp \
    pinentry \
    "
