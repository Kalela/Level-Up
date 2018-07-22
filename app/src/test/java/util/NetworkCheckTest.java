package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class NetworkCheckTest {

        private Context context;
        private NetworkInfo networkInfo;
        private ConnectivityManager connectivityManager;

        @Before
        public void setUp() throws Exception {
            context = Mockito.mock(Context.class);
            networkInfo = Mockito.mock(NetworkInfo.class);
            connectivityManager = Mockito.mock(ConnectivityManager.class);
        }

        @Test
        public void getConnectivityStatusReturnsTrueWhenActiveNetworkInfoIsNotNull() throws Exception {
            Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);
            Mockito.when(connectivityManager.getActiveNetworkInfo()).thenReturn(networkInfo);
            Mockito.when(networkInfo.isConnectedOrConnecting()).thenReturn(true);

            Assert.assertTrue(NetworkCheck.getConnectionStatus(context));

            Mockito.verify(networkInfo).isConnectedOrConnecting();
        }

        @Test
        public void getConnectivityStatusReturnsFalseWhenActiveNetworkInfoIsNull() throws Exception {
            Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager);
            Mockito.when(connectivityManager.getActiveNetworkInfo()).thenReturn(null);

            Assert.assertFalse(NetworkCheck.getConnectionStatus(context));
        }

}