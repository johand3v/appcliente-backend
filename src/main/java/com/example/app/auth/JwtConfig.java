package com.example.app.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA="alguna.clave.secreta.12345678";
    public static final String RSA_PRIVADA ="-----BEGIN PRIVATE KEY-----\r\n" +
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC+BwDm03bF6D8c\r\n" +
            "yxTD2M05uDPvHtODoXiAbtcCZUHjWqEyDTS40X/Whv4ho+1AWBGSyhqaqkpQO2WP\r\n" +
            "BCm48wzjZ7/YAEs2ab7d3vcg1hhXsJ/SItSJ4hai9XKgkOy9D7AqSAX7Q8hgBGS6\r\n" +
            "Oal6JBW2gJwsbhWxEK5ilKwY7/gd9IR1hi/g4bbshJ8kwv7K1FA7hYb3SJJPWdkP\r\n" +
            "otUptihGctHuWUA+mYHnoFs7Cf3k/8y2L0OEI5Nz7R7nAQXu1zZwefARaMF7iH2A\r\n" +
            "r/BekBYdheENVzxj4+7T5Hmn9TiD3CHQM7HIb9HL5fJ/su22tMwelhJ+9F6zm5tb\r\n" +
            "pbohf+pjAgMBAAECggEABSo/CcNaUARfWKpFQbf5aPx79R+l7uUFk/brhwCGGyag\r\n" +
            "J1CAop35QkvPFOyV/cdo6TlYqbblZGAA7MJ9PKbIrqHJ2H/UmpRXhgeOKhhKdyaH\r\n" +
            "0vY3sPufabZxici6aOvXGCzCOGRNHP883j3iGvKF2Oo0hXAMNh/jvgD5+OGMqQKN\r\n" +
            "iT4zHkqIMTdbsIoDE+p0cm9E1PLloQxBxDlZnPILPy4t+W3gQ4K1ymAqyI7dt2Vl\r\n" +
            "nL6sv5HU8iELBEh7VRQYQLTe5TBEZM+7JN2cnxmUoAG9mHLczNi2jWowfHN1Bn4G\r\n" +
            "dQOR4SeEuff6hv7mV1boT4uSUQVuufiPWoYNtY8IfQKBgQDCmu0+PUeOI5iCcGUD\r\n" +
            "xwdaJY0TeWnUBiZ229hcRskAk4RdQ/9tF2vPRVjSpkhgexMNNVSDHdJJmHq1DTox\r\n" +
            "4k9ZdwyotMNMqFRQAIUiNjWA9KNrVIVfRSQYKpi6GI/9i0Og5a0WgFjPwtcIZ8A9\r\n" +
            "E0YcR5dO4D0JCAvMpRHhDCPgxQKBgQD5+lqSM7iKSLfw2C+ojyFZZAbNFA9YY26e\r\n" +
            "xH5XGL/1jH2CM3zUT4LCGJutDDUGFpNt0v3ux5zWVY3d/NSMjSS9+1/nK819ZO2a\r\n" +
            "na0c5zw+ZAmpeDfcOTulK/XCLocxP4PlfRwMypilZaXX990pIPoM42r94eZyC9nO\r\n" +
            "mYf7yFQBBwKBgQC3FLoNy+j9uE9KqCLgouYv0RQgNiFx7zdQqxOp/I4tlJr6g3ZS\r\n" +
            "U66BmWQvCXEeE6ugyYNwtyWXR3Rp0L/nHlo4eN/X9/ekrthjS5n0zbsYTw9Pcnzn\r\n" +
            "XEzQz4JP0bvldJdzT6C/gpALJerXZYRd8TwMbu3SrvO9A2zWYpWne5xlYQKBgHB3\r\n" +
            "8TQCTS76VLfprFecPhbn6B9wvQ65fdW09lrdadBiaz2fSLSFKYGGbNRIv7qDgcVR\r\n" +
            "vqol6SyNxYxw6nhqMHPBm354uLWIKVb9RhvQ9cvkWmyDCC7vGSTRSHsbT/waZY9k\r\n" +
            "4K/onxEbUKiAfmK40Yfm8gZUEsiRCGfpr8LaeOEVAoGAfFlVoIBJjj04SKajaV7b\r\n" +
            "tPOLajZQ67mcJqMZ//n8HoVHfhZSL2nBu1SPwFI2Q6v85xxm39U/Ug8W9dwOk/LD\r\n" +
            "fZKZmEQb4Y1suQzDnfge1XcdiQziJ2Jdy4Lp8LWJABf53yU/uSjDIEnsWIQm5rml\r\n" +
            "MmpfNhSeNFphqzSJriJlQ7M=\r\n" +
            "-----END PRIVATE KEY-----";

    public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvgcA5tN2xeg/HMsUw9jN\r\n" +
            "Obgz7x7Tg6F4gG7XAmVB41qhMg00uNF/1ob+IaPtQFgRksoamqpKUDtljwQpuPMM\r\n" +
            "42e/2ABLNmm+3d73INYYV7Cf0iLUieIWovVyoJDsvQ+wKkgF+0PIYARkujmpeiQV\r\n" +
            "toCcLG4VsRCuYpSsGO/4HfSEdYYv4OG27ISfJML+ytRQO4WG90iST1nZD6LVKbYo\r\n" +
            "RnLR7llAPpmB56BbOwn95P/Mti9DhCOTc+0e5wEF7tc2cHnwEWjBe4h9gK/wXpAW\r\n" +
            "HYXhDVc8Y+Pu0+R5p/U4g9wh0DOxyG/Ry+Xyf7LttrTMHpYSfvRes5ubW6W6IX/q\r\n" +
            "YwIDAQAB\n" +
            "-----END PUBLIC KEY-----";


}
