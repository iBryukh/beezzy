package beezzy.services.impl;

import beezzy.services.StorageService;
import com.dropbox.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by oleh_kurpiak on 20.04.16.
 */
@Component
public class StorageServiceImpl implements StorageService {

    @Autowired
    private DbxClient dbxClient;

    @Override
    public boolean uploadGoodsImage(MultipartFile file, int id){
        if(file == null)
            return false;

        try {
            return uploadFile(file, id, GOODS_FOLDER);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void downloadGoodsImage(OutputStream outputStream, int id) throws IOException, DbxException {
        downloadFile(outputStream, id, GOODS_FOLDER);
    }

    @Override
    public boolean uploadCategoryImage(MultipartFile file, int id) {
        if(file == null)
            return false;

        try {
            return uploadFile(file, id, CATEGORY_FOLDER);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void downloadCategoryImage(OutputStream outputStream, int id) throws IOException, DbxException {
        downloadFile(outputStream, id, CATEGORY_FOLDER);
    }

    /**
     *
     * @param file - file to be saved
     * @param id - identifier of file
     * @param prefix - folder
     * @return success
     * @throws IOException
     * @throws DbxException
     */
    private boolean uploadFile(MultipartFile file, Object id, String prefix) throws IOException, DbxException {
        InputStream inputStream = null;
        try {
            try {
                dbxClient.delete('/' + prefix + '/' + id);
            } catch (Exception e){
                //file not found. so do nothing
            }
            inputStream = new ByteArrayInputStream(file.getBytes());
            dbxClient.uploadFile('/' + prefix + '/' + id, DbxWriteMode.add(), file.getBytes().length, inputStream);
            return true;
        } finally {
            try {
                if(inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param outputStream - stream for file
     * @param id - identifier of file
     * @param prefix - folder
     * @throws IOException
     * @throws DbxException
     */
    private void downloadFile(OutputStream outputStream, Object id, String prefix) throws IOException, DbxException {
        dbxClient.getFile('/'+ prefix + '/' + id, null, outputStream);
    }

    private static final String GOODS_FOLDER = "goods";
    private static final String CATEGORY_FOLDER = "category";

}
