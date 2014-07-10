DESCRIPTION = "Image with Security utilities support" 
LICENSE = "MIT"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_LINGUAS = " "

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	util-linux-agetty \
	packagegroup-core-full-cmdline \
	packagegroup-core-security \
"   

inherit core-image distro_features_check

DISTRO_FEATURES = "pax"


