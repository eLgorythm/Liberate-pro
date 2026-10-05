# Liberate Pro
<img align='right' src='Liberate-mini.svg' width='220px' alt="liberate logo">

[English](../README.md) | **简体中文** | [日本語](../ja/README.md) | [Türkçe](../tr/README.md)

一个 Android 上基于内核的 root 方案。

[![最新发行](https://img.shields.io/github/v/release/elgorythm/Liberate?label=Release&logo=github)](https://github.com/elgorythm/Liberate/releases/latest)
[![协议: GPL v2](https://img.shields.io/badge/License-GPL%20v2-orange.svg?logo=gnu)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
[![GitHub 协议](https://img.shields.io/github/license/elgorythm/Liberate?logo=gnu)](/LICENSE)

## 特性

1. 基于内核的 `su` 和权限管理。
2. App Profile: 把 Root 权限关进笼子里。
3. 支持 non-GKI 与 GKI 1.0。
4. KPM 支持
5. 可调整管理器外观，可自定义 susfs 配置。

## 兼容状态

- KernelSU 官方支持 GKI 2.0 的设备（内核版本 5.10 以上）。

- 旧内核也是兼容的（最低 4.14+），不过需要自己编译内核。

- 通过更多的反向移植，KernelSU 可以支持 3.x 内核（3.4-3.18）。

- 目前支持架构 : `arm64-v8a`、`armeabi-v7a (bare)`、`X86_64`。

## 安装指导

查看 [`guide/installation.md`](guide/installation.md)

## 集成指导

查看 [`guide/how-to-integrate.md`](guide/how-to-integrate.md)

## 参与翻译

要将 Liberate 翻译成您的语言，或完善现有的翻译，请使用 [Crowdin](https://crowdin.com/project/Liberate-Pro).

## KPM 支持

- 基于 KernelPatch 开发，移除了与 KernelSU 重复的功能。
- 正在进行（WIP）：通过集成附加功能来扩展 APatch 兼容性，以确保跨不同实现的兼容性。

**KPM 模板**: [https://github.com/udochina/KPM-Build-Anywhere](https://github.com/udochina/KPM-Build-Anywhere)

> [!Note]
>
> 1. 需要 `CONFIG_KPM=y`
> 2. Non-GKI 设备需要 `CONFIG_KALLSYMS=y` and `CONFIG_KALLSYMS_ALL=y`
> 3. 对于低于 `4.19` 的内核，需要从 `4.19` 的 `set_memory.h` 进行反向移植。

## 故障排除

1. 卸载管理器后系统卡住？
   卸载 _com.sony.playmemories.mobile_

## 许可证

- 目录 `kernel` 下所有文件为 [GPL-2.0-only](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)。
- 有动漫人物图片表情包的这些文件 `ic_launcher(?!.*alt.*).*` 图标以特别的形式授权，怡子曰曰绘制，版权明风OuO所有。矢量化图标由本项目提供。详见 [`LICENSE_icon_English`](./LICENSE_icon_English) 与 [`LICENSE_icon_SC`](./LICENSE_icon_SC)。
- 除上述文件及目录的其他部分均为 [GPL-3.0-or-later](https://www.gnu.org/licenses/gpl-3.0.html)。
