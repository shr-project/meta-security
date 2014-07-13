# Copyright (c) 2014 MontaVista Software, LLC.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

SAMHAIN_MODE="client"
INITSCRIPT_PARAMS = "defaults 15 85"

require samhain.inc

#Let the default Logserver be 127.0.0.1
EXTRA_OECONF += "--with-logserver=127.0.0.1 \
                 --with-config-file=/etc/samhainrc \
		 --with-data-file=/var/lib/samhain/samhain_file \
		"


pkg_postinst_${PN}_append() {
}

FILES_${PN} += "\
    /run \
    "

