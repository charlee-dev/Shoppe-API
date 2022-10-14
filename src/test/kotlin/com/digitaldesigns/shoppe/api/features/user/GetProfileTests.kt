package com.digitaldesigns.shoppe.api.features.user

import com.digitaldesigns.shoppe.api.helpers.SchemaTest
import org.amshove.kluent.shouldBeEqualTo
import kotlin.test.Test
import kotlin.test.assertNull

class GetProfileTests : SchemaTest() {
    private val getProfileQuery =
        "query GetUserProfile { getUserProfile { user { id displayName email imageUrl }}}"

    @Test
    fun `getUserProfile, if user signed in should return User Profile`() {
        test(query = getProfileQuery, assert = { response ->
            response.data.toString() shouldBeEqualTo "{getUserProfile={user={id=user1id, displayName=Adrian, email=testEmail1, imageUrl=image1}}}"
            assertNull(response.errors)
        })
    }
}
