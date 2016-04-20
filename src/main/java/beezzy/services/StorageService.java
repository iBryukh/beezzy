package beezzy.services;

import com.dropbox.core.DbxException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by oleh_kurpiak on 20.04.16.
 */
public interface StorageService {

    boolean uploadGoodsImage(MultipartFile file, int id);
    void downloadGoodsImage(OutputStream outputStream, int id) throws IOException, DbxException;

    boolean uploadCategoryImage(MultipartFile file, int id);
    void downloadCategoryImage(OutputStream outputStream, int id) throws IOException, DbxException;

}
