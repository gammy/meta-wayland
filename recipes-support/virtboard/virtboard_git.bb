SUMMARY = "A basic keyboard, blazing the path of modern Wayland keyboards."
HOMEPAGE = "https://source.puri.sm/Librem5/virtboard"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=0ebb9978fd668af3c88c6dfa393e866d"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS = " \
	cairo \
	glib-2.0-native \
	libpng \
	libxkbcommon \
	pixman \
	wayland \
	wayland-native \
	wayland-protocols \
"

SRC_URI = " \
	git://source.puri.sm/Librem5/virtboard.git;protocol=https \
"

inherit meson pkgconfig gtk-icon-cache features_check

S = "${WORKDIR}/git"
PV = "0.0.6"
SRCREV = "v${PV}"

FILES:${PN} += "${datadir}"

BBCLASSEXTEND = ""

