DESCRIPTION = "wireshark - a popular network protocol analyzer"
HOMEPAGE = "http://www.wireshark.org"
SECTION = "network"
LICENSE = "GPL-2.0"
DEPENDS = "perl-native gnutls libpcap pcre expat glib-2.0 libsmi gtk+3"

EXTRA_OECONF = "--with-gtk2=yes --with-qt=no --enable-usr-local=no --enable-wireshark --enable-tshark" 

LIC_FILES_CHKSUM = "file://README.linux;md5=631e077455b7972172eb149195e065b0"

#SRC_URI = "${SOURCEFORGE_MIRROR}/wireshark/wireshark-${PV}.tar.bz2"
SRC_URI = "https://2.na.dl.wireshark.org/src/wireshark-${PV}.tar.bz2"
SRC_URI[md5sum] = "dc1149073066a29f91116c168558262e"
SRC_URI[sha256sum]= "31009bb450126e9b12808267419f31016d14e6fde7b5e39c85ad37459908cffb"

inherit autotools


