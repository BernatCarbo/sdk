package com.doordeck.multiplatform.sdk.internal.api

import com.doordeck.multiplatform.sdk.api.LockOperationsResource
import com.doordeck.multiplatform.sdk.api.model.BatchShareLockOperationData
import com.doordeck.multiplatform.sdk.api.model.GetAuditForUserData
import com.doordeck.multiplatform.sdk.api.model.GetLockAuditTrailData
import com.doordeck.multiplatform.sdk.api.model.GetLocksForUserData
import com.doordeck.multiplatform.sdk.api.model.GetSingleLockData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByEmailData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByEmailsData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByForeignKeyData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByForeignKeysData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByIdentityData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByLocalKeyData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByLocalKeysData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByTelephoneData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyByTelephonesData
import com.doordeck.multiplatform.sdk.api.model.GetUserPublicKeyData
import com.doordeck.multiplatform.sdk.api.model.GetUsersForLockData
import com.doordeck.multiplatform.sdk.api.model.LockOperations
import com.doordeck.multiplatform.sdk.api.model.RevokeAccessToLockOperationData
import com.doordeck.multiplatform.sdk.api.model.SetLockSettingPermittedAddressesData
import com.doordeck.multiplatform.sdk.api.model.SetLockSettingTimeRestrictionsData
import com.doordeck.multiplatform.sdk.api.model.ShareLockOperationData
import com.doordeck.multiplatform.sdk.api.model.UnlockOperationData
import com.doordeck.multiplatform.sdk.api.model.UpdateLockColourData
import com.doordeck.multiplatform.sdk.api.model.UpdateLockFavouriteData
import com.doordeck.multiplatform.sdk.api.model.UpdateLockNameData
import com.doordeck.multiplatform.sdk.api.model.UpdateLockSettingDefaultNameData
import com.doordeck.multiplatform.sdk.api.model.UpdateLockSettingHiddenData
import com.doordeck.multiplatform.sdk.api.model.UpdateLockSettingLocationRestrictionsData
import com.doordeck.multiplatform.sdk.api.model.UpdateSecureSettingUnlockBetweenData
import com.doordeck.multiplatform.sdk.api.model.UpdateSecureSettingUnlockDurationData
import com.doordeck.multiplatform.sdk.api.model.toBatchShareLockOperation
import com.doordeck.multiplatform.sdk.api.model.toLocationRequirement
import com.doordeck.multiplatform.sdk.api.model.toRevokeAccessToLockOperation
import com.doordeck.multiplatform.sdk.api.model.toShareLockOperation
import com.doordeck.multiplatform.sdk.api.model.toTimeRequirementList
import com.doordeck.multiplatform.sdk.api.model.toUnlockOperation
import com.doordeck.multiplatform.sdk.api.model.toUpdateSecureSettingUnlockBetween
import com.doordeck.multiplatform.sdk.api.model.toUpdateSecureSettingUnlockDuration
import com.doordeck.multiplatform.sdk.api.responses.AuditResponse
import com.doordeck.multiplatform.sdk.api.responses.BatchUserPublicKeyResponse
import com.doordeck.multiplatform.sdk.api.responses.LockResponse
import com.doordeck.multiplatform.sdk.api.responses.LockUserResponse
import com.doordeck.multiplatform.sdk.api.responses.ShareableLockResponse
import com.doordeck.multiplatform.sdk.api.responses.UserLockResponse
import com.doordeck.multiplatform.sdk.api.responses.UserPublicKeyResponse
import com.doordeck.multiplatform.sdk.util.fromJson
import com.doordeck.multiplatform.sdk.util.resultData
import kotlinx.coroutines.runBlocking

internal object LockOperationsResourceImpl : LockOperationsResource {

    override fun getSingleLock(lockId: String): LockResponse {
        return runBlocking { LockOperationsClient.getSingleLockRequest(lockId) }
    }

    override fun getSingleLockJson(data: String): String {
        return resultData {
            val getSingleLockData = data.fromJson<GetSingleLockData>()
            getSingleLock(getSingleLockData.lockId)
        }
    }

    override fun getLockAuditTrail(lockId: String, start: Int, end: Int): List<AuditResponse> {
        return runBlocking { LockOperationsClient.getLockAuditTrailRequest(lockId, start, end) }
    }

    override fun getLockAuditTrailJson(data: String): String {
        return resultData {
            val getLockAuditTrailData = data.fromJson<GetLockAuditTrailData>()
            getLockAuditTrail(getLockAuditTrailData.lockId, getLockAuditTrailData.start, getLockAuditTrailData.end)
        }
    }

    override fun getAuditForUser(userId: String, start: Int, end: Int): List<AuditResponse> {
        return runBlocking { LockOperationsClient.getAuditForUserRequest(userId, start, end) }
    }

    override fun getAuditForUserJson(data: String): String {
        return resultData {
            val getAuditForUserData = data.fromJson<GetAuditForUserData>()
            getAuditForUser(getAuditForUserData.userId, getAuditForUserData.start, getAuditForUserData.end)
        }
    }

    override fun getUsersForLock(lockId: String): List<UserLockResponse> {
        return runBlocking { LockOperationsClient.getUsersForLockRequest(lockId) }
    }

    override fun getUsersForLockJson(data: String): String {
        return resultData {
            val getUsersForLockData = data.fromJson<GetUsersForLockData>()
            getUsersForLock(getUsersForLockData.lockId)
        }
    }

    override fun getLocksForUser(userId: String): LockUserResponse {
        return runBlocking { LockOperationsClient.getLocksForUserRequest(userId) }
    }

    override fun getLocksForUserJson(data: String): String {
        return resultData {
            val getLocksForUserData = data.fromJson<GetLocksForUserData>()
            getLocksForUser(getLocksForUserData.userId)
        }
    }

    override fun updateLockName(lockId: String, name: String?) {
        return runBlocking { LockOperationsClient.updateLockNameRequest(lockId, name) }
    }

    override fun updateLockNameJson(data: String): String {
        return resultData {
            val updateLockNameData = data.fromJson<UpdateLockNameData>()
            updateLockName(updateLockNameData.lockId, updateLockNameData.name)
        }
    }

    override fun updateLockFavourite(lockId: String, favourite: Boolean?) {
        return runBlocking { LockOperationsClient.updateLockFavouriteRequest(lockId, favourite) }
    }

    override fun updateLockFavouriteJson(data: String): String {
        return resultData {
            val updateLockFavouriteData = data.fromJson<UpdateLockFavouriteData>()
            updateLockFavourite(updateLockFavouriteData.lockId, updateLockFavouriteData.favourite)
        }
    }

    override fun updateLockColour(lockId: String, colour: String?) {
        return runBlocking { LockOperationsClient.updateLockColourRequest(lockId, colour) }
    }

    override fun updateLockColourJson(data: String): String {
        return resultData {
            val updateLockColourData = data.fromJson<UpdateLockColourData>()
            updateLockColour(updateLockColourData.lockId, updateLockColourData.colour)
        }
    }

    override fun updateLockSettingDefaultName(lockId: String, name: String?) {
        return runBlocking { LockOperationsClient.updateLockSettingDefaultNameRequest(lockId, name) }
    }

    override fun updateLockSettingDefaultNameJson(data: String): String {
        return resultData {
            val updateLockSettingDefaultNameData = data.fromJson<UpdateLockSettingDefaultNameData>()
            updateLockSettingDefaultName(updateLockSettingDefaultNameData.lockId, updateLockSettingDefaultNameData.name)
        }
    }

    override fun setLockSettingPermittedAddresses(lockId: String, permittedAddresses: List<String>) {
        return runBlocking { LockOperationsClient.setLockSettingPermittedAddressesRequest(lockId, permittedAddresses) }
    }

    override fun setLockSettingPermittedAddressesJson(data: String): String {
        return resultData {
            val setLockSettingPermittedAddressesData = data.fromJson<SetLockSettingPermittedAddressesData>()
            setLockSettingPermittedAddresses(setLockSettingPermittedAddressesData.lockId, setLockSettingPermittedAddressesData.permittedAddresses)
        }
    }

    override fun updateLockSettingHidden(lockId: String, hidden: Boolean) {
        return runBlocking { LockOperationsClient.updateLockSettingHiddenRequest(lockId, hidden) }
    }

    override fun updateLockSettingHiddenJson(data: String): String {
        return resultData {
            val updateLockSettingHiddenData = data.fromJson<UpdateLockSettingHiddenData>()
            updateLockSettingHidden(updateLockSettingHiddenData.lockId, updateLockSettingHiddenData.hidden)
        }
    }

    override fun setLockSettingTimeRestrictions(lockId: String, times: List<LockOperations.TimeRequirement>) {
        return runBlocking { LockOperationsClient.setLockSettingTimeRestrictionsRequest(lockId, times) }
    }

    override fun setLockSettingTimeRestrictionsJson(data: String): String {
        return resultData {
            val setLockSettingTimeRestrictionsData = data.fromJson<SetLockSettingTimeRestrictionsData>()
            setLockSettingTimeRestrictions(setLockSettingTimeRestrictionsData.lockId, setLockSettingTimeRestrictionsData.times.toTimeRequirementList())
        }
    }

    override fun updateLockSettingLocationRestrictions(lockId: String, location: LockOperations.LocationRequirement?) {
        return runBlocking { LockOperationsClient.updateLockSettingLocationRestrictionsRequest(lockId, location) }
    }

    override fun updateLockSettingLocationRestrictionsJson(data: String): String {
        return resultData {
            val updateLockSettingLocationRestrictionsData = data.fromJson<UpdateLockSettingLocationRestrictionsData>()
            updateLockSettingLocationRestrictions(updateLockSettingLocationRestrictionsData.lockId, updateLockSettingLocationRestrictionsData.location?.toLocationRequirement())
        }
    }

    override fun getUserPublicKey(userEmail: String, visitor: Boolean): UserPublicKeyResponse {
        return runBlocking { LockOperationsClient.getUserPublicKeyRequest(userEmail, visitor) }
    }

    override fun getUserPublicKeyJson(data: String): String {
        return resultData {
            val getUserPublicKeyData = data.fromJson<GetUserPublicKeyData>()
            getUserPublicKey(getUserPublicKeyData.userEmail, getUserPublicKeyData.visitor)
        }
    }

    override fun getUserPublicKeyByEmail(email: String): UserPublicKeyResponse {
        return runBlocking { LockOperationsClient.getUserPublicKeyByEmailRequest(email) }
    }

    override fun getUserPublicKeyByEmailJson(data: String): String {
        return resultData {
            val getUserPublicKeyData = data.fromJson<GetUserPublicKeyByEmailData>()
            getUserPublicKeyByEmail(getUserPublicKeyData.email)
        }
    }

    override fun getUserPublicKeyByTelephone(telephone: String): UserPublicKeyResponse {
        return runBlocking { LockOperationsClient.getUserPublicKeyByTelephoneRequest(telephone) }
    }

    override fun getUserPublicKeyByTelephoneJson(data: String): String {
        return resultData {
            val getUserPublicKeyByTelephoneData = data.fromJson<GetUserPublicKeyByTelephoneData>()
            getUserPublicKeyByTelephone(getUserPublicKeyByTelephoneData.telephone)
        }
    }

    override fun getUserPublicKeyByLocalKey(localKey: String): UserPublicKeyResponse {
        return runBlocking { LockOperationsClient.getUserPublicKeyByLocalKeyRequest(localKey) }
    }

    override fun getUserPublicKeyByLocalKeyJson(data: String): String {
        return resultData {
            val getUserPublicKeyByLocalKeyData = data.fromJson<GetUserPublicKeyByLocalKeyData>()
            getUserPublicKeyByLocalKey(getUserPublicKeyByLocalKeyData.localKey)
        }
    }

    override fun getUserPublicKeyByForeignKey(foreignKey: String): UserPublicKeyResponse {
        return runBlocking { LockOperationsClient.getUserPublicKeyByForeignKeyRequest(foreignKey) }
    }

    override fun getUserPublicKeyByForeignKeyJson(data: String): String {
        return resultData {
            val getUserPublicKeyByForeignKeyData = data.fromJson<GetUserPublicKeyByForeignKeyData>()
            getUserPublicKeyByForeignKey(getUserPublicKeyByForeignKeyData.foreignKey)
        }
    }

    override fun getUserPublicKeyByIdentity(identity: String): UserPublicKeyResponse {
        return runBlocking { LockOperationsClient.getUserPublicKeyByIdentityRequest(identity) }
    }

    override fun getUserPublicKeyByIdentityJson(data: String): String {
        return resultData {
            val getUserPublicKeyByIdentityData = data.fromJson<GetUserPublicKeyByIdentityData>()
            getUserPublicKeyByIdentity(getUserPublicKeyByIdentityData.identity)
        }
    }

    override fun getUserPublicKeyByEmails(emails: List<String>): List<BatchUserPublicKeyResponse> {
        return runBlocking { LockOperationsClient.getUserPublicKeyByEmailsRequest(emails) }
    }

    override fun getUserPublicKeyByEmailsJson(data: String): String {
        return resultData {
            val getUserPublicKeyByEmailsData = data.fromJson<GetUserPublicKeyByEmailsData>()
            getUserPublicKeyByEmails(getUserPublicKeyByEmailsData.emails)
        }
    }

    override fun getUserPublicKeyByTelephones(telephones: List<String>): List<BatchUserPublicKeyResponse> {
        return runBlocking { LockOperationsClient.getUserPublicKeyByTelephonesRequest(telephones) }
    }

    override fun getUserPublicKeyByTelephonesJson(data: String): String {
        return resultData {
            val getUserPublicKeyByTelephonesData = data.fromJson<GetUserPublicKeyByTelephonesData>()
            getUserPublicKeyByTelephones(getUserPublicKeyByTelephonesData.telephones)
        }
    }

    override fun getUserPublicKeyByLocalKeys(localKeys: List<String>): List<BatchUserPublicKeyResponse> {
        return runBlocking { LockOperationsClient.getUserPublicKeyByLocalKeysRequest(localKeys) }
    }

    override fun getUserPublicKeyByLocalKeysJson(data: String): String {
        return resultData {
            val getUserPublicKeyByLocalKeysData = data.fromJson<GetUserPublicKeyByLocalKeysData>()
            getUserPublicKeyByLocalKeys(getUserPublicKeyByLocalKeysData.localKeys)
        }
    }

    override fun getUserPublicKeyByForeignKeys(foreignKeys: List<String>): List<BatchUserPublicKeyResponse> {
        return runBlocking { LockOperationsClient.getUserPublicKeyByForeignKeysRequest(foreignKeys) }
    }

    override fun getUserPublicKeyByForeignKeysJson(data: String): String {
        return resultData {
            val getUserPublicKeyByForeignKeysData = data.fromJson<GetUserPublicKeyByForeignKeysData>()
            getUserPublicKeyByForeignKeys(getUserPublicKeyByForeignKeysData.foreignKeys)
        }
    }

    override fun unlock(unlockOperation: LockOperations.UnlockOperation) {
        return runBlocking { LockOperationsClient.unlockRequest(unlockOperation) }
    }

    override fun unlockJson(data: String): String {
        return resultData {
            val unlockOperationData = data.fromJson<UnlockOperationData>()
            unlock(unlockOperationData.toUnlockOperation())
        }
    }

    override fun shareLock(shareLockOperation: LockOperations.ShareLockOperation) {
        return runBlocking { LockOperationsClient.shareLockRequest(shareLockOperation) }
    }

    override fun shareLockJson(data: String): String {
        return resultData {
            val shareLockOperationData = data.fromJson<ShareLockOperationData>()
            shareLock(shareLockOperationData.toShareLockOperation())
        }
    }

    override fun batchShareLock(batchShareLockOperation: LockOperations.BatchShareLockOperation) {
        return runBlocking { LockOperationsClient.batchShareLockRequest(batchShareLockOperation) }
    }

    override fun batchShareLockJson(data: String): String {
        return resultData {
            val batchShareLockOperationData = data.fromJson<BatchShareLockOperationData>()
            batchShareLock(batchShareLockOperationData.toBatchShareLockOperation())
        }
    }

    override fun revokeAccessToLock(revokeAccessToLockOperation: LockOperations.RevokeAccessToLockOperation) {
        return runBlocking { LockOperationsClient.revokeAccessToLockRequest(revokeAccessToLockOperation) }
    }

    override fun revokeAccessToLockJson(data: String): String {
        return resultData {
            val revokeAccessToLockOperationData = data.fromJson<RevokeAccessToLockOperationData>()
            revokeAccessToLock(revokeAccessToLockOperationData.toRevokeAccessToLockOperation())
        }
    }

    override fun updateSecureSettingUnlockDuration(updateSecureSettingUnlockDuration: LockOperations.UpdateSecureSettingUnlockDuration) {
        return runBlocking { LockOperationsClient.updateSecureSettingUnlockDurationRequest(updateSecureSettingUnlockDuration) }
    }

    override fun updateSecureSettingUnlockDurationJson(data: String): String {
        return resultData {
            val updateSecureSettingUnlockDurationData = data.fromJson<UpdateSecureSettingUnlockDurationData>()
            updateSecureSettingUnlockDuration(updateSecureSettingUnlockDurationData.toUpdateSecureSettingUnlockDuration())
        }
    }

    override fun updateSecureSettingUnlockBetween(updateSecureSettingUnlockBetween: LockOperations.UpdateSecureSettingUnlockBetween) {
        return runBlocking { LockOperationsClient.updateSecureSettingUnlockBetweenRequest(updateSecureSettingUnlockBetween) }
    }

    override fun updateSecureSettingUnlockBetweenJson(data: String): String {
        return resultData {
            val updateSecureSettingUnlockBetweenData = data.fromJson<UpdateSecureSettingUnlockBetweenData>()
            updateSecureSettingUnlockBetween(updateSecureSettingUnlockBetweenData.toUpdateSecureSettingUnlockBetween())
        }
    }

    override fun getPinnedLocks(): List<LockResponse> {
        return runBlocking { LockOperationsClient.getPinnedLocksRequest() }
    }

    override fun getPinnedLocksJson(): String {
        return resultData {
            getPinnedLocks()
        }
    }

    override fun getShareableLocks(): List<ShareableLockResponse> {
        return runBlocking { LockOperationsClient.getShareableLocksRequest() }
    }

    override fun getShareableLocksJson(): String {
        return resultData {
            getShareableLocks()
        }
    }
}