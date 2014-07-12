<<<<<<< HEAD
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

# Toyomo kernel support
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'tomoyo', ' file://tomoyo.cfg', '', d)}"
=======
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Toyomo kernel support
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'toyomo', ' file://toyomo.cfg', '', d)}"
>>>>>>> 8fde7476ed55d7f4371835e337afbb659fb73ffc
