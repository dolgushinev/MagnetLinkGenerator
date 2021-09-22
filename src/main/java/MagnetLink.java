import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MagnetLink {

    private String hexDigest;

    private String magnetLink;

    public MagnetLink(String path) throws IOException {

        try (InputStream is = Files.newInputStream(Paths.get(path))) {
            byte[] sha256 = DigestUtils.sha256(is);
            hexDigest = Hex.encodeHexString(sha256);

            magnetLink = generateMagnetlink(new File(path));

        }

    }

    private String generateMagnetlink(File file) {

        System.out.println("magnet:?xt=urn:btih:" + getHexDigest() + "&xl:" + file.length() + "&dn:" + file.getName());

        return "magnet:?xt=urn:btih:" + getHexDigest() + "&xl:" + file.length() + "&dn:" + file.getName();
    }

    public String getMagnetLink() {
        return magnetLink;
    }

    public String getHexDigest() {
        return hexDigest;
    }
}