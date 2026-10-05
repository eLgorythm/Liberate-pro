package id.liberate.pro.data.repository

import id.liberate.pro.data.model.RepoModule

interface ModuleRepoRepository {
    suspend fun fetchModules(): Result<List<RepoModule>>
}
