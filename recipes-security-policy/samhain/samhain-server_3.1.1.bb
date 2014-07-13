# Copyright (c) 2014 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

SAMHAIN_MODE="server"
INITSCRIPT_PARAMS = "defaults 14 86"

require samhain.inc

SRC_URI += "file://samhain-server-volatiles"

do_install_append() {
    cd ${S}
    # The yule config has an error, some items in the Database
    # section are uncommented, so the database section has to be
    # uncommented.
    sed -i 's/^# \[Database]/[Database]/' ${D}${sysconfdir}/yulerc

    install -d ${D}${sysconfdir}/default/volatiles
    install -m 0644 ${WORKDIR}/samhain-server-volatiles \
    ${D}${sysconfdir}/default/volatiles/samhain-server
    rmdir ${D}/run
}

