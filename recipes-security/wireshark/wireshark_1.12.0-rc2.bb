DESCRIPTION = "wireshark - a popular network protocol analyzer"
HOMEPAGE = "http://www.wireshark.org"
SECTION = "network"
LICENSE = "GPL-2.0"
DEPENDS = "perl-native libpcap pcre expat glib-2.0 libsmi"

inherit autotools

PACKAGECONFIG ??= "gnutls gtk2 ${@bb.utils.contains("DISTRO_FEATURES", "ipv6", "ipv6", "", d)}"

PACKAGECONFIG[gtk2] = "--with-gtk2=yes --enable-wireshark,--with-gtk2=no --disable-wireshark, gtk+"
PACKAGECONFIG[ipv6] = "--enable-ipv6,--disable-ipv6,"
PACKAGECONFIG[gnutls] = "--with-gnutls=yes,--with-gnutls=no, gnutls"
PACKAGECONFIG[libgcrypt] = "--with-gcrypt=yes,--with-gcrypt=no, gcrypt"

EXTRA_OECONF = "--with-gtk3=no --with-qt=no --enable-usr-local=no --with-gnu-ld -enable-tshark"

LIC_FILES_CHKSUM = "file://README.linux;md5=631e077455b7972172eb149195e065b0"
SRC_URI = "http://wiresharkdownloads.riverbed.com/wireshark/src/wireshark-1.12.0-rc2.tar.bz2 \
    file://configure-glib-cross-prefix.patch \
    "
SRC_URI[md5sum] = "dc1149073066a29f91116c168558262e"
SRC_URI[sha256sum]= "31009bb450126e9b12808267419f31016d14e6fde7b5e39c85ad37459908cffb"

ALLOW_EMPTY_${PN} = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

