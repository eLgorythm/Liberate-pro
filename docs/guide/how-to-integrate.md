# Integrate

Liberate can be integrated into both _GKI_ and _non-GKI_ kernels and has been backported to _4.14_.

Some OEMs' customization could result in as much as 50% of kernel code being out-of-tree code and not from upstream Linux kernels or ACKs. Due to this, the custom nature of _non-GKI_ kernels resulted in significant kernel fragmentation, and we lacked a universal method for building them. Therefore, we cannot provide boot images of _non-GKI_ kernels.

Prerequisites: open source bootable kernel.

### Hook method

1. **KPROBES hook:**

   - Default hook method on GKI kernels.
   - Requires `# CONFIG_KSU_MANUAL_HOOK is not set` & `CONFIG_KPROBES=y`
   - Used for Loadable Kernel Module (LKM).

2. **Manual hook:**

   - Requires `CONFIG_KSU_MANUAL_HOOK=y`
   - Requires [`guide/how-to-integrate.md`](guide/how-to-integrate.md)

3. **Tracepoint Hook:**

   - Hook method introduced since Liberate commit [49b01aad](https://github.com/elgorythm/Liberate/commit/49b01aad74bcca6dba5a8a2e053bb54b648eb124)
   - Requires `CONFIG_KSU_TRACEPOINT_HOOK=y`
   - Requires [`guide/tracepoint-hook.md`](tracepoint-hook.md)


If you're able to build a bootable kernel, there are two ways to integrate Liberate into the kernel source code:

1. Automatically with `kprobe`
2. Manually

## Integrate with kprobe

Applicable:

- _GKI_ kernel

Not applicable:

- _non-GKI_ kernel

Liberate uses kprobe to do kernel hooks. If kprobe runs well in your kernel, it's recommended to use it this way.

The execution command for the step that adds Liberate to your kernel source tree is replaced with:

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s main
```

## Manually modify the kernel source

Applicable:

- GKI kernel
- non-GKI kernel

There is another way to integrate but still work in the process.

Run command for the step that adds Liberate to your kernel source tree is replaced with:

### GKI kernel

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s main
```

### Built-in kernel

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s builtin
```

### GKI / Built-in kernel with susfs (experiment)

```sh
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s susfs-{{branch}}
```

Branch:

- `main` (susfs-main)
- `test` (susfs-test)
- version (for example: susfs-1.5.7, you should check the [branches](https://github.com/elgorythm/Liberate/branches))
