# 集成指导

Liberate 可以集成到 GKI 和 non-GKI 内核中，并且已反向移植到 4.14 版本。

有些 OEM 定制可能导致多达 50% 的内核代码超出内核树代码，而非来自上游 Linux 内核或 ACK。因此，non-GKI 内核的定制特性导致了严重的内核碎片化，而且我们缺乏构建它们的通用方法。因此，我们无法提供 non-GKI 内核的启动映像。

前提条件：开源的、可启动的内核。

## Hook 方法

1. **KPROBES hook:**
   - GKI kernels 的默认 hook 方法。
   - 需要 `# CONFIG_KSU_MANUAL_HOOK is not set`（未设定） & `CONFIG_KPROBES=y`
   - 用作可加载的内核模块 (LKM).

2. **Manual hook:**

   - 需要 `CONFIG_KSU_MANUAL_HOOK=y`
   - 需要 [`guide/how-to-integrate.md`](how-to-integrate.md)

3. **Tracepoint Hook:**
   - 自 Liberate commit [49b01aad](https://github.com/elgorythm/Liberate/commit/49b01aad74bcca6dba5a8a2e053bb54b648eb124) 引入的 hook 方法
   - 需要 `CONFIG_KSU_TRACEPOINT_HOOK=y`
   - 需要 [`guide/tracepoint-hook.md`](tracepoint-hook.md)


如果您能够构建可启动内核，有两种方法可以将 Liberate 集成到内核源代码中：

1. 使用 `kprobe` 自动集成
2. 手动集成

## 与 kprobe 集成

适用：

- GKI 内核

不适用：

- non-GKI 内核

Liberate 使用 kprobe 机制来做内核的相关 hook，如果 _kprobe_ 可以在你编译的内核中正常运行，那么推荐用这个方法来集成。

替换 Liberate 添加到内核源代码树的步骤的执行命令为：

```sh [bash]
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s main
```

## 手动修改内核源代码

适用：

- GKI 内核
- non-GKI 内核

还有另一种集成方法，但是仍在开发中。

将 Liberate 添加到内核源代码树的步骤的运行命令将被替换为：

### GKI 内核

```sh [bash]
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s main
```

### Built-in 内核

```sh [bash]
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s builtin
```

### 带有 susfs 的 GKI / Built-in 内核（实验）

```sh [bash]
curl -LSs "https://raw.githubusercontent.com/elgorythm/Liberate/main/kernel/setup.sh" | bash -s susfs-{{branch}}
```

分支:

- `main` (susfs-main)
- `test` (susfs-test)
- 版本号 (例如: susfs-1.5.7, 你需要在 [分支](https://github.com/elgorythm/Liberate/branches) 里找到它)
