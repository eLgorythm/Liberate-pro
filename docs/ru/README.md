# Liberate Pro
<img align='right' src='Liberate-mini.svg' width='220px' alt="логотип liberate">

[English](../README.md) | [简体中文](./zh/README.md) | [日本語](./ja/README.md) | [Türkçe](./tr/README.md) | **Русский**

Решение для получения root-прав на уровне ядра для устройств Android.

[![Latest release](https://img.shields.io/github/v/release/elgorythm/Liberate?label=Release&logo=github)](https://github.com/elgorythm/Liberate/releases/latest)
[![License: GPL v2](https://img.shields.io/badge/License-GPL%20v2-orange.svg?logo=gnu)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
[![GitHub License](https://img.shields.io/github/license/elgorythm/Liberate?logo=gnu)](/LICENSE)

## Особенности

1. Управление доступом `su` и root на уровне ядра.
2. App Profile: закройте root-права для конкретных приложений.
3. Поддержка non-GKI и GKI 1.0.
4. Поддержка KPM.
5. Изменения в теме менеджера и встроенный susfs.

## Статус совместимости

- KernelSU (до v1.0.0) официально поддерживает устройства Android GKI 2.0 (ядро 5.10+).

- Более старые ядра (4.4+) также совместимы, но ядро придется собирать вручную.

- С дополнительными бэкпортами KernelSU может поддерживать ядра серии 3.x (3.4–3.18).

- На данный момент поддерживаются только архитектуры `arm64-v8a`, `armeabi-v7a (bare)` и некоторые `X86_64`.

## Установка

См. [`guide/installation.md`](guide/installation.md)

## Интеграция

См. [`guide/how-to-integrate.md`](guide/how-to-integrate.md)

## Перевод

Если вы хотите предложить перевод для менеджера, пожалуйста, воспользуйтесь [Crowdin](https://crowdin.com/project/Liberate-Pro).

## Поддержка KPM

- На базе KernelPatch: мы удалили функции, дублирующие возможности KSU, оставив только поддержку KPM.
- В разработке: расширение совместимости с APatch путем интеграции дополнительных функций для обеспечения работы в различных реализациях.

**Шаблон KPM**: [https://github.com/udochina/KPM-Build-Anywhere](https://github.com/udochina/KPM-Build-Anywhere)

> [!Note]
>
> 1. Требуется `CONFIG_KPM=y`
> 2. Для non-GKI устройств требуются `CONFIG_KALLSYMS=y` и `CONFIG_KALLSYMS_ALL=y`
> 3. Для ядер ниже `4.19` требуется бэкпорт `set_memory.h` из версии `4.19`.

## Устранение неполадок

1. Если устройство зависает при удалении менеджера (liberate) 
   Удалите com.sony.playmemories.mobile

## Лицензия

- Файлы в директории «kernel» находятся под лицензией [GPL-2.0-only](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
- Изображения файлов `ic_launcher(?!.*alt.*).*` с аниме-персонажами лицензированы особым образом: рисунок [怡子曰曰](https://space.bilibili.com/10545509), авторское право принадлежит [明风 OuO](https://space.bilibili.com/274939213), векторизованные иконки предоставлены этим проектом. Подробнее см. [`LICENSE_icon_English`](./LICENSE_icon_English) и [`LICENSE_icon_SC`](./LICENSE_icon_SC).
- За исключением вышеуказанных файлов и директорий, все остальные части находятся под лицензией [GPL-3.0 or later](https://www.gnu.org/licenses/gpl-3.0.html)
