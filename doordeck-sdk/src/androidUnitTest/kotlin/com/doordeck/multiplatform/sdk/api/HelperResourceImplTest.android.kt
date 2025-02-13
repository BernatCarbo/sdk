package com.doordeck.multiplatform.sdk.api

import com.doordeck.multiplatform.sdk.MockTest
import com.doordeck.multiplatform.sdk.TestConstants.DEFAULT_APPLICATION_ID
import com.doordeck.multiplatform.sdk.internal.api.HelperResourceImpl
import kotlinx.coroutines.future.await
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class HelperResourceImplTest : MockTest() {

    @Test
    fun shouldUploadPlatformLogo() = runTest {
        HelperResourceImpl.uploadPlatformLogo(DEFAULT_APPLICATION_ID, "", byteArrayOf())
    }

    @Test
    fun shouldUploadPlatformLogoAsync() = runTest {
        HelperResourceImpl.uploadPlatformLogoAsync(DEFAULT_APPLICATION_ID, "", byteArrayOf()).await()
    }
}