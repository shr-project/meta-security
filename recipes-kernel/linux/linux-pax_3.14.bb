DESCRIPTION = "Yocto Pax  Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel


S = "${WORKDIR}/linux-${PV}.12"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.12.tar.gz \
        file://grsecurity-3.0-3.14.12-201407100035.patch \
        "

# Pax kernel support
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'pax', ' file://pax.cfg', '', d)}"


SRC_URI[md5sum] = "b83310140e68ed8ffb89434da9caddb0"
SRC_URI[sha256sum] = "8ab47d1b88356daba2c73636c274f4896886c8ccdd5b9c5662df511beb5482d4"

