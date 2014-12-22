package com.googlecode.lucene.osem.config;

import com.googlecode.lucene.osem.annotations.Indexable;

public class AnnotationsMappingBinding implements MappingBinding {

    @Override
    public boolean addClass(final Class<?> clazz) {
        final Indexable indexable = clazz.getAnnotation(Indexable.class);
        if (indexable == null) {
            return false;
        }

        // TODO Auto-generated method stub
        return false;
    }

}
