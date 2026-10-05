# Интеграция

Liberate можно интегрировать как в ядра _GKI_, так и в _non-GKI_. Выполнен бэкпорт до версии _4.14_.

Кастомизация некоторых OEM-производителей приводит к тому, что до 50% кода ядра является сторонним (out-of-tree) и не относится к апстриму Linux или ACK (Android Common Kernel). Из-за этого фрагментация _non-GKI_ ядер очень высока, и универсального способа их сборки не существует. По этой причине мы не можем предоставить готовые образы загрузки (boot images) для _non-GKI_ ядер.

Предварительное условие: наличие открытых исходных кодов рабочего ядра.

### Методы перехвата (хуков)

1. **KPROBES hook:**

   - Метод по умолчанию для GKI ядер.
   - Требует: `# CONFIG_KSU_MANUAL_HOOK is not set` и `CONFIG_KPROBES=y`.
   - Используется для загружаемых модулей ядра (LKM).

2. **Manual hook:**

   - Требует: `CONFIG_KSU_MANUAL_HOOK=y`.
   - Инструкция: [`guide/how-to-integrate.md`](guide/how-to-integrate.md).

3. **Tracepoint Hook:**

   - Метод представлен в Liberate начиная с коммита [49b01aad](https://github.com/elgorythm/Liberate/commit/49b01aad74bcca6dba5a8a2e053bb54b648eb124).
   - Требует: `CONFIG_KSU_TRACEPOINT_HOOK=y`
   - Инструкция: [`guide/tracepoint-hook.md`](tracepoint-hook.md)


Если вы умеете собирать ядро из исходников, есть два способа интегрировать Liberate:

1. Автоматически через `kprobe`.
2. Вручную.

## Интеграция через kprobe

Применимо для:

- _GKI_ kernel

Не применимо для:

- _non-GKI_ kernel

Liberate использует механизм kprobe для создания хуков. Если в вашем ядре kprobe работает корректно, рекомендуется использовать именно этот способ.

Команда для добавления Liberate (писать в корневой папке исходников ядра):

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s main
```

## Ручная модификация исходного кода ядра

Применимо для:

- GKI kernel
- non-GKI kernel

Существует еще один способ интеграции, но он находится в процессе доработки.

Команды для добавления Liberate в дерево исходников вашего ядра:

### GKI ядро

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s main
```

### Встроенное ядро (Built-in)

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s builtin
```

### GKI / Built-in ядро с поддержкой susfs (экспериментально)

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s susfs-{{branch}}
```

Доступные ветки (Branch):

- `main` (susfs-main)
- `test` (susfs-test)
- конкретная версия (например: susfs-1.5.7, проверить доступные варианты можно в разделе [branches](https://github.com/elgorythm/Liberate/branches))
