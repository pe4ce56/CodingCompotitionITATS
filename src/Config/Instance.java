package Config;

import Service.UserService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

public class Instance {
    private final Map<String, Object> controllerRegistry = new HashMap<>();
    private final Map<String, Object> viewRegistry = new HashMap<>();
    private static Instance instance;
    public static Instance getInstance() {
        if(instance==null){
            instance = new Instance();
        }
        return instance;
    }
    public void instanceController(){
        String packageName = "Controller";
        List<String> fileList = getAllFilesInPackage(packageName);
        for (String fileName : fileList) {
            try{
                Object instance = getController( fileName);
//                Class<?> clazz = Class.forName(packageName + "." + fileName);
//                clazz.getMethod("addData").invoke(instance);
            }catch (ClassNotFoundException e) {
                System.out.println("Error -> " + e.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void instanceView() {
        String packageName = "View";
        List<String> fileList = getAllFilesInPackage(packageName);
        for (String fileName : fileList) {
            try{
                Object instance = getView( fileName);
//                Class<?> clazz = Class.forName(packageName + "." + fileName);
//                clazz.getMethod("addData").invoke(instance);
            }catch (ClassNotFoundException e) {
                System.out.println("Error -> " + e.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object getController(String className) throws Exception {
        className = "Controller." + className;
        if (!controllerRegistry.containsKey(className)) {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            controllerRegistry.put(className, instance);
        }
        return controllerRegistry.get(className);
    }

    public Object getView(String className) throws Exception {
        className = "View." + className;
        if (!viewRegistry.containsKey(className)) {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            viewRegistry.put(className, instance);
        }
        return viewRegistry.get(className);
    }

    private List<String> getAllFilesInPackage(String packageName) {
        List<String> fileList = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            URL resource = classLoader.getResource(path);
            if (resource != null) {
                File packageDir = new File(resource.toURI());
                addFilesInPackage(packageDir, packageName, fileList);
            } else {
                System.err.println("Package not found: " + packageName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileList;
    }

    private void addFilesInPackage(File directory, String packageName, List<String> fileList) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = Arrays.stream(file.getName().split("\\.")).toList().get(0);
                    fileList.add(fileName);
                } else if (file.isDirectory()) {
                    addFilesInPackage(file, packageName + "/" + file.getName(), fileList);
                }
            }
        }
    }

}
