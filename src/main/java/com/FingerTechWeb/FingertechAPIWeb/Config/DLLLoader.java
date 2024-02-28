package com.FingerTechWeb.FingertechAPIWeb.Config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DLLLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final String DLL_NAME = "NBioBSPJNI.dll";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            loadDLL();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDLL() throws IOException {
        File dllFile = extractDLL();
        if (dllFile != null) {
            System.load(dllFile.getAbsolutePath());
        }
    }

    private File extractDLL() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/" + DLL_NAME);
        if (inputStream != null) {
            File tempFile = File.createTempFile(DLL_NAME, ".dll");
            tempFile.deleteOnExit();
            try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
                StreamUtils.copy(inputStream, outputStream);
            }
            return tempFile;
        }
        return null;
    }
}