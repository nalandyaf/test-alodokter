package com.test.alodokter.data.remote;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.test.alodokter.domain.entities.requests.LoginRequest;
import com.test.alodokter.domain.entities.response.LoginResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Single;

import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class UserRepositoryTest {

    UserRepository userRepository;


    @Before
    public void setUp() throws Exception {
        userRepository = UserRepository.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLoginSuccessful() {
        Single<LoginResponse> response = userRepository.login(new LoginRequest("+628218", "123"));
        assertFalse(response.blockingGet().getJwt().isEmpty());

    }

}