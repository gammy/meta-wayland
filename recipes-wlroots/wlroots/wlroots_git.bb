SUMMARY = "A modular Wayland compositor library"
DESCRIPTION = "Pluggable, composable, unopinionated modules for building a \
Wayland compositor; or about 50,000 lines of code you were \
going to write anyway."
HOMEPAGE = "https://gitlab.freedesktop.org/wlroots"
BUGTRACKER = "https://gitlab.freedesktop.org/wlroots/wlroots/-/issues"
SECTION = "graphics"
LICENSE = "MIT"

# 0.17.1:
LIC_FILES_CHKSUM = "file://LICENSE;md5=89e064f90bcb87796ca335cbd2ce4179"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	libxkbcommon \
	pixman \
	seatd \
	virtual/libgbm \
	wayland \
	wayland-native \
	wayland-protocols \
    hwdata \
    pkgconfig \
    pkgconfig-native \
    libdisplay-info \
"

PACKAGECONFIG[examples] = "-Dexamples=true,-Dexamples=false"
PACKAGECONFIG[gles] = ",,virtual/egl virtual/libgles2"
PACKAGECONFIG[libdrm] = ",,libdrm"
PACKAGECONFIG[libinput] = ",,libinput"
PACKAGECONFIG[systemd] = ",,systemd"
PACKAGECONFIG[sysvinit] = ",,eudev elogind"
PACKAGECONFIG[vulkan] = ",,vulkan-loader vulkan-headers glslang glslang-native"
PACKAGECONFIG[x11] = ",,xcb-util-renderutil"
PACKAGECONFIG[xwayland] = "-Dxwayland=enabled,-Dxwayland=disabled,xwayland xcb-util-wm"

PACKAGECONFIG ?= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
	${@bb.utils.filter('DISTRO_FEATURES', 'sysvinit', d)} \
	${@bb.utils.filter('DISTRO_FEATURES', 'vulkan', d)} \
	${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)} \
	libinput \
"

SRC_URI = "git://gitlab.freedesktop.org/wlroots/wlroots.git;branch=0.17;protocol=https \
           file://0001-backend-drm-make-pkg-config-look-for-hwdata-on-the-t.patch \
           "
# 0.17.1:
SRCREV = "3f2aced8c6fd00b0b71da24c790850af2004052b"

PV = "0.17.1"

S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

EXTRA_OEMESON += "--buildtype release"

BBCLASSEXTEND = ""

