package br.com.animals

import br.com.animals.di.ApiModule
import br.com.animals.model.AnimalApiService
import org.mockito.Mock

class ApiModuleTest(val mockService: AnimalApiService): ApiModule() {
}