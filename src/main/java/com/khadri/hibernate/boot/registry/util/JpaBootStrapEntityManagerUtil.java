package com.khadri.hibernate.boot.registry.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;

public class JpaBootStrapEntityManagerUtil {

	public static EntityManager getEntityMager() {

		Properties props = new Properties();
		try {
			props.load(new FileReader(
					new File("src/main/resources/persistence.properties")));
		} catch (IOException e) {
		}

		EntityManagerFactory emf = new HibernatePersistenceProvider()
				.createContainerEntityManagerFactory(
						createPersistenceUintInfo(), props);

		return emf.createEntityManager();
	}

	public static PersistenceUnitInfo createPersistenceUintInfo() {
		PersistenceUnitInfo info = new PersistenceUnitInfo() {

			@Override
			public ValidationMode getValidationMode() {
				return null;
			}

			@Override
			public PersistenceUnitTransactionType getTransactionType() {
				return null;
			}

			@Override
			public SharedCacheMode getSharedCacheMode() {
				return null;
			}

			@Override
			public Properties getProperties() {
				return new Properties();
			}

			@Override
			public String getPersistenceXMLSchemaVersion() {
				return null;
			}

			@Override
			public URL getPersistenceUnitRootUrl() {
				return null;
			}

			@Override
			public String getPersistenceUnitName() {
				return "KHADRI PERISTENCE UNIT";
			}

			@Override
			public String getPersistenceProviderClassName() {
				return "org.hibernate.jpa.HibernatePersistenceProvider";
			}

			@Override
			public DataSource getNonJtaDataSource() {
				return null;
			}

			@Override
			public ClassLoader getNewTempClassLoader() {
				return null;
			}

			@Override
			public List<String> getMappingFileNames() {
				return List.of();
			}

			@Override
			public List<String> getManagedClassNames() {
				return List.of("com.khadri.hibernate.boot.entities.Customer",
						"com.khadri.hibernate.boot.entities.Order");
			}

			@Override
			public DataSource getJtaDataSource() {
				return null;
			}

			@Override
			public List<URL> getJarFileUrls() {
				return List.of();
			}

			@Override
			public ClassLoader getClassLoader() {
				return null;
			}

			@Override
			public boolean excludeUnlistedClasses() {
				return false;
			}

			@Override
			public void addTransformer(ClassTransformer transformer) {

			}
		};

		return info;
	}

}
