DESCRIPTION = "Image with Security utility support" 

IMAGE_FEATURES += "splash ssh-server-openssh"

LICENSE = "MIT"

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	util-linux-agetty \
	packagegroup-core-full-cmdline \
	packagegroup-core-security \
"   

inherit core-image
