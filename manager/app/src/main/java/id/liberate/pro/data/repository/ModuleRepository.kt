package id.liberate.pro.data.repository

import id.liberate.pro.data.model.Module
import id.liberate.pro.data.model.ModuleUpdateInfo

interface ModuleRepository {
    suspend fun getModules(): Result<List<Module>>
    suspend fun checkUpdate(module: Module): Result<ModuleUpdateInfo>
}
