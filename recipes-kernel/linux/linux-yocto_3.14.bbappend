FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Toyomo kernel support
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'toyomo', ' file://toyomo.cfg', '', d)}"
