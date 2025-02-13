package com.doordeck.multiplatform.sdk.api

import com.doordeck.multiplatform.sdk.api.model.LockOperations
import com.doordeck.multiplatform.sdk.api.responses.AuditResponse
import com.doordeck.multiplatform.sdk.api.responses.BatchUserPublicKeyResponse
import com.doordeck.multiplatform.sdk.api.responses.LockResponse
import com.doordeck.multiplatform.sdk.api.responses.LockUserResponse
import com.doordeck.multiplatform.sdk.api.responses.ShareableLockResponse
import com.doordeck.multiplatform.sdk.api.responses.UserLockResponse
import com.doordeck.multiplatform.sdk.api.responses.UserPublicKeyResponse
import com.doordeck.multiplatform.sdk.internal.api.DoordeckOnly
import com.doordeck.multiplatform.sdk.internal.api.LockOperationsResourceImpl

actual interface LockOperationsResource {
    /**
     * Get a single lock
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-a-single-lock">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getSingleLock(lockId: String): LockResponse

    /**
     * Get lock audit trail
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-lock-audit-trail-v2">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getLockAuditTrail(lockId: String, start: Int, end: Int): List<AuditResponse>

    /**
     * Get audit for a user
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-audit-for-a-user">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getAuditForUser(userId: String, start: Int, end: Int): List<AuditResponse>

    /**
     * Get users for a lock
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-users-for-a-lock">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUsersForLock(lockId: String): List<UserLockResponse>

    /**
     * Get locks for a user
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-locks-for-a-user">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getLocksForUser(userId: String): LockUserResponse

    /**
     * Update lock properties - Name
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateLockName(lockId: String, name: String? = null)

    /**
     * Update lock properties - Favourite
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateLockFavourite(lockId: String, favourite: Boolean? = null)

    /**
     * Update lock properties - Colour
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateLockColour(lockId: String, colour: String? = null)

    /**
     * Update lock properties - Settings - Default name
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateLockSettingDefaultName(lockId: String, name: String? = null)

    /**
     * Set lock properties - Settings - Permitted addresses
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun setLockSettingPermittedAddresses(lockId: String, permittedAddresses: List<String>)

    /**
     * Update lock properties - Settings - Hidden
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateLockSettingHidden(lockId: String, hidden: Boolean)

    /**
     * Set lock properties - Settings - Usage requirements - Time
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun setLockSettingTimeRestrictions(lockId: String, times: List<LockOperations.TimeRequirement>)

    /**
     * Update lock properties - Settings - Usage requirements - Location
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-lock-properties">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateLockSettingLocationRestrictions(lockId: String, location: LockOperations.LocationRequirement? = null)

    /**
     * Get user’s public key
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-a-doordeck-user-s-public-key">API Doc</a>
     */
    @DoordeckOnly
    @Throws(Exception::class)
    suspend fun getUserPublicKey(userEmail: String, visitor: Boolean = false): UserPublicKeyResponse

    /**
     * Get a user’s public key by email
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v1">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByEmail(email: String): UserPublicKeyResponse

    /**
     * Get a user’s public key by telephone
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v1">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByTelephone(telephone: String): UserPublicKeyResponse

    /**
     * Get a user’s public key by local key
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v1">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByLocalKey(localKey: String): UserPublicKeyResponse

    /**
     * Get a user’s public key by foreign key
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v1">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByForeignKey(foreignKey: String): UserPublicKeyResponse

    /**
     * Get a user’s public key
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v1">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByIdentity(identity: String): UserPublicKeyResponse

    /**
     * Get a user’s public key by email
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v2">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByEmails(emails: List<String>): List<BatchUserPublicKeyResponse>

    /**
     * Get a user’s public key by telephone
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v2">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByTelephones(telephones: List<String>): List<BatchUserPublicKeyResponse>

    /**
     * Get a user’s public key by local key
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v2">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByLocalKeys(localKeys: List<String>): List<BatchUserPublicKeyResponse>

    /**
     * Get a user’s public key by foreign key
     *
     * @see <a href="https://developer.doordeck.com/docs/#lookup-user-public-key-v2">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getUserPublicKeyByForeignKeys(foreignKeys: List<String>): List<BatchUserPublicKeyResponse>

    /**
     * Unlock
     *
     * @see <a href="https://developer.doordeck.com/docs/#unlock">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun unlock(unlockOperation: LockOperations.UnlockOperation)

    /**
     * Share a lock
     *
     * @see <a href="https://developer.doordeck.com/docs/#share-a-lock">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun shareLock(shareLockOperation: LockOperations.ShareLockOperation)

    /**
     * Batch share a lock
     *
     * @see <a href="https://developer.doordeck.com/docs/#batch-share-a-lock-v2">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun batchShareLock(batchShareLockOperation: LockOperations.BatchShareLockOperation)

    /**
     * Revoke access to a lock
     *
     * @see <a href="https://developer.doordeck.com/docs/#revoke-access-to-a-lock">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun revokeAccessToLock(revokeAccessToLockOperation: LockOperations.RevokeAccessToLockOperation)

    /**
     * Update secure settings - Unlock duration
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-secure-settings">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateSecureSettingUnlockDuration(updateSecureSettingUnlockDuration: LockOperations.UpdateSecureSettingUnlockDuration)

    /**
     * Update secure settings - Unlock between
     *
     * @see <a href="https://developer.doordeck.com/docs/#update-secure-settings">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun updateSecureSettingUnlockBetween(updateSecureSettingUnlockBetween: LockOperations.UpdateSecureSettingUnlockBetween)

    /**
     * Get pinned locks
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-pinned-locks">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getPinnedLocks(): List<LockResponse>

    /**
     * Get shareable locks
     *
     * @see <a href="https://developer.doordeck.com/docs/#get-shareable-locks">API Doc</a>
     */
    @Throws(Exception::class)
    suspend fun getShareableLocks(): List<ShareableLockResponse>
}

actual fun lockOperations(): LockOperationsResource = LockOperationsResourceImpl