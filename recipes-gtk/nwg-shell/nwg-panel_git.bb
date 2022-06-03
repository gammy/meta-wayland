SUMMARY = "GTK3-based panel for wayland."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fffa55ad1c828db5e334374fb1182530"

SRC_URI = " \
	git://github.com/nwg-piotr/nwg-panel.git;protocol=https;branch=master \
"

RDEPENDS:${PN} = "\
	bash \
	light \
	python3 \
	python3-pygobject \
	python3-psutil \
	python-i3ipc \
	swaync \
"

inherit setuptools3

S = "${WORKDIR}/git"
PV = "0.6.5"
SRCREV = "cc2dc687a47123b959d67b3735c4c5727508eda2"

