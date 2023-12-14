package com.example.cp3.common.exception

import com.example.cp3.common.BusinessCode
import com.example.cp3.common.Code.ServiceError
import com.example.cp3.common.Code.CodeName

class ApiException : RuntimeException  {
    var error: BusinessCode? = null


    constructor() : super()

    constructor(msg: String) : super(msg)

    constructor(service: ServiceError, codename: CodeName) : super(codename.message) {
        this.error = BusinessCode(service, codename)
    }

    constructor(businessCode: BusinessCode) : super() {
        this.error = businessCode
    }

    constructor(service: ServiceError, codename: CodeName, obj: Any, errorMessage: String) : super(errorMessage) {
        this.error = BusinessCode(service, codename, obj, errorMessage)
    }

    constructor(service: ServiceError, codename: CodeName, errorMessage: String) : super(errorMessage) {
        this.error = BusinessCode(service, codename, errorMessage)
    }
}