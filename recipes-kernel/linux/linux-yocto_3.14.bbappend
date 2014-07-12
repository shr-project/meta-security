FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Toyomo kernel support 
#KERNEL_FEATURES_append += "${@base_contains('DISTRO_FEATURES', 'toyomo', ' features/toyomo/toyomo-enable.scc', '', d)}"

# Toyomo kernel support
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'toyomo', ' file://toyomo.cfg', '', d)}"
