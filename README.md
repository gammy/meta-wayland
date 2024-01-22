Note: This is a fork of https://codeberg.org/flk/meta-wayland.git
If you obtained this repo from my fork (https://github.com/gammy/meta-wayland),
consider using the upstream repository instead, as I'm currently focusing on
updating the kirkstone branch for my particular needs.

The below information stems from the upstream source.

Wayland/Wlroots Layer for OpenEmbedded/Yocto

Main layer maintainer: Markus Volk <f_l_k@t-online.de>

Description

This layer adds recipes to build wlroots based compositors under wayland.
It contains wlroots, sway, wayfire, cage, phosh, hyprland, nwg-shell and some additional recipes that might come useful.

Dependencies

This layer depends on:

    URI: git://github.com/openembedded/openembedded-core
        branch: master
        revision: HEAD
    URI: git://github.com/openembedded/meta-openembedded
        branch: master
        revision: HEAD

optional for hyprlands desktop-portal:

    URI: git://code.qt.io/cgit/yocto/meta-qt6
        branch: master
        revision: HEAD

Building

Follow the usual steps to setup OpenEmbedded and bitbake.

