SUMMARY = "EDID and DisplayID library"
DESCRIPTION = "Provide a set of high-level, easy-to-use, opinionated functions as well as low-level functions to access detailed information."
HOMEPAGE = "https://gitlab.freedesktop.org/emersion/libdisplay-info"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=e4426409957080ee0352128354cea2de"

DEPENDS += " hwdata"

SRC_URI = "git://gitlab.freedesktop.org/emersion/libdisplay-info/;branch=main;protocol=https \
           file://0001-make-pkg-config-look-for-hwdata-on-the-t.patch \
           "
SRCREV = "92b031749c0fe84ef5cdf895067b84a829920e25"

PV = "0.1.1"

S = "${WORKDIR}/git"

inherit meson pkgconfig 

EXTRA_OEMESON += "--buildtype release"
BBCLASSEXTEND = ""

do_install:append() {
    # Paranoia check
    for item in ${FILES:${PN}}; do
        files=$(ls -1 ${D}/$item)
        for f in $files
        do
            if [ ! -e "$f" ]; then
                bbnote "WARNING: File '$f' specified in FILES variable does not exist."
            fi
        done
    done

}

FILES:${PN} = " \
${includedir}/${PN}/* \
${libdir}/${PN}.so.${PV} \
${libdir}/${PN}.so.1 \
${libdir}/${PN}.so \
${libdir}/pkgconfig/${PN}.pc \
${bindir}/di-edid-decode \
"
