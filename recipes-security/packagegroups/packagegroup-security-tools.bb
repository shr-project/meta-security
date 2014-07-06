DESCRIPTION = "Security tools packagegroup for Poky"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit packagegroup

PACKAGES = "\
    packagegroup-core-security \
    packagegroup-security-audit \
    packagegroup-security-tools \
    "

RDEPENDS_packagegroup-security-audit = " \
    buck-security \
    checksecurity \
    redhat-security \
    "
RDEPENDS_packagegroup-security-tools = " \
    bastille \
    "
