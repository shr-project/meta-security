SUMMARY = "Program radominization"
DESCRIPTION = "The checksec.sh script is designed to test what standard Linux OS and PaX security features are being used."
SECTION = "security"
LICENSE = "GPL-2.0"
HOMEPAGE="http://www.trapkit.de/tools/checksec.html"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://checksec.sh"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/checksec.sh    ${D}${bindir}
}