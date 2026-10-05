# Liberate Pro
<img align='right' src='Liberate-mini.svg' width='220px' alt="liberate logo">

**English** | [简体中文](./zh/README.md) | [日本語](./ja/README.md) | [Türkçe](./tr/README.md) | [Русский](./ru/README.md)

A kernel-based root solution for Android devices.

[![Latest release](https://img.shields.io/github/v/release/elgorythm/Liberate?label=Release&logo=github)](https://github.com/elgorythm/Liberate/releases/latest)
[![License: GPL v2](https://img.shields.io/badge/License-GPL%20v2-orange.svg?logo=gnu)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
[![GitHub License](https://img.shields.io/github/license/elgorythm/Liberate?logo=gnu)](/LICENSE)

## Features

1. Kernel-based `su` and root access management
2. App Profile: Lock up the root power in a cage
3. Support non-GKI and GKI 1.0
4. KPM Support
5. Tweaks to the manager theme and the built-in susfs management tool.

## Compatibility Status

- Liberate (before v1.0.0) officially supports Android GKI 2.0 devices (kernel 5.10+).

- Older kernels (4.4+) are also compatible, but the kernel will have to be built manually.

- With more backports, Liberate can supports 3.x kernel (3.4-3.18).

- Currently, only `arm64-v8a`, `armeabi-v7a (bare)` and `X86_64`(some) are supported.

## Installation

See [`guide/installation.md`](guide/installation.md)

## Integration

See [`guide/how-to-integrate.md`](guide/how-to-integrate.md)

## Translation

If you need to submit a translation for the manager, please go to [Crowdin](https://crowdin.com/project/Liberate-Pro).

## KPM Support

- Based on KernelPatch, we removed features redundant with KSU and retained only KPM support.
- Work in Progress: Expanding APatch compatibility by integrating additional functions to ensure compatibility across different implementations.

**KPM template**: [https://github.com/udochina/KPM-Build-Anywhere](https://github.com/udochina/KPM-Build-Anywhere)

> [!Note]
>
> 1. Requires `CONFIG_KPM=y`
> 2. Non-GKI devices requires `CONFIG_KALLSYMS=y` and `CONFIG_KALLSYMS_ALL=y`
> 3. For kernels below `4.19`, backporting from `set_memory.h` from `4.19` is required.

## Troubleshooting

1. Device stuck upon manager app uninstallation?
   Uninstall _com.sony.playmemories.mobile_

## License

- The file in the “kernel” directory is under [GPL-2.0-only](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html) license.
- The images of the files `ic_launcher(?!.*alt.*).*` with anime character artwork are licensed under a special arrangement: drawn by [怡子曰曰](https://space.bilibili.com/10545509), the copyright is held by [明风 OuO](https://space.bilibili.com/274939213), and the vectorized icons are provided by this project. See [`LICENSE_icon_English`](./LICENSE_icon_English) and [`LICENSE_icon_SC`](./LICENSE_icon_SC) for details.
- Except for the files or directories mentioned above, all other parts are under [GPL-3.0 or later](https://www.gnu.org/licenses/gpl-3.0.html) license.
