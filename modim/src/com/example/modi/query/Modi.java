package com.example.modi.query;

import java.util.Objects;

/**
 * Created by hakan on 12/11/2017
 */
public final class Modi {

    /**
     * find whether the target keyword exists in the module system or not
     * @param keyword searchable module or package name
     * @return true if the keyword exists, otherwise false
     */
    public boolean exists(String keyword) {

        // this module is an application module
        final Module module = Modi.class.getModule();
        final ModuleLayer moduleLayer = module.getLayer();

        return moduleLayer.modules()
                .parallelStream()
                .anyMatch(layer ->
                        keyword.equalsIgnoreCase(layer.getName()) ||
                                layer.getPackages().stream().anyMatch(pck -> pck.equalsIgnoreCase(keyword)));


    }
}
