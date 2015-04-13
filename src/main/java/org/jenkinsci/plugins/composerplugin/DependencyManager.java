package org.jenkinsci.plugins.composerplugin;

import java.io.File;
import java.util.Iterator;

import com.dubture.getcomposer.core.ComposerPackage;
import com.dubture.getcomposer.core.VersionedPackage;
import com.dubture.getcomposer.core.collection.Dependencies;

public class DependencyManager {

	public static void main(String[] args) throws Exception {
		File composerJson = new File(DependencyManager.class.getResource("/composer.json").getFile());
		ComposerPackage pkg = new ComposerPackage(composerJson);
		Dependencies deps = pkg.getRequire();
		Iterator<VersionedPackage> it = deps.iterator();
		System.out.println("Project dependencies:");
		while (it.hasNext()) {
			VersionedPackage vp = it.next();
			System.out.println(vp.toJson());
		}
	}

}
