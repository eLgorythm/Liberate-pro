# Installation

## Installation by loading the Loadable Kernel Module (LKM)

Beginning with **Android™** (trademark meaning licensed Google Mobile Services) 12, devices shipping with kernel version 5.10 or higher must ship with the GKI kernel. You may be able to use LKM mode.

To install in LKM mode:

1. Install the Liberate Pro manager app on the device.
2. Obtain the stock `boot.img` / `init_boot.img` matching your current build and copy it to the device.
3. In the manager, open Install and select the image to patch.
4. Copy the patched image to a PC, reboot the device to fastboot (`adb reboot bootloader`), and flash it (`fastboot flash init_boot <patched>.img` or `fastboot flash boot <patched>.img`).
5. Reboot and verify the status in the manager.

## Installation by installing the kernel

Although some devices can be installed using LKM mode, they cannot be installed on the device by using the GKI kernel; therefore, the kernel needs to be modified manually to compile it. For example:

- OPPO (OnePlus, REALME)
- Meizu

> [!Note]
>
> - You only need to fill in the first two parts of the version number, e.g. `5.10`, `6.1`...
> - Make sure you know the processor designation, kernel version, etc. before you use it.
