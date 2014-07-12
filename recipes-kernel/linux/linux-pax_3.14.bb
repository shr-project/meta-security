DESCRIPTION = "Yocto Pax Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel


S = "${WORKDIR}/linux-${PV}.12"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.12.tar.gz;name=kernel \
    http://grsecurity.net/~paxguy1/pax-linux-${PV}.12-test13.patch;name=pax \
    file://configs/config.x86_64 \
    "

# Pax kernel support
#SRC_URI += "${@base_contains('DISTRO_FEATURES', 'pax', 'file://grsecurity-3.0-3.14.12-201407100035.patch', '', d)}"
#SRC_URI += "${@base_contains('DISTRO_FEATURES', 'pax', ' file://pax.cfg', '', d)}"


SRC_URI[kernel.md5sum] = "b83310140e68ed8ffb89434da9caddb0"
SRC_URI[kernel.sha256sum] = "8ab47d1b88356daba2c73636c274f4896886c8ccdd5b9c5662df511beb5482d4"

SRC_URI[pax.md5sum] = "a96abc66c1429870e7080407e35c4cee"
SRC_URI[pax.sha256sum] = "8a4fbe30b2ad6ea27cd6dbbcf4167aa9797195712063d1a002dadfd5292073b5"

# Disable gcc plugin support for now
EXTRA_OEMAKE += "DISABLE_PAX_PLUGINS=y CONFIG_SND_KORG1212=n"

