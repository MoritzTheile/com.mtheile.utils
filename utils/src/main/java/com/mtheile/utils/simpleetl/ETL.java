package com.mtheile.utils.simpleetl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mtheile.utils.simpleetl.mapping.AttribMapping.MAPPING_TYPE;
import com.mtheile.utils.simpleetl.mapping.TableMapping;

@Component
public class ETL {

	@PersistenceContext(unitName = "targetEntityManagerFactory")
	private EntityManager emTarget;

	@PersistenceContext(unitName = "sourceEntityManagerFactory")
	private EntityManager emSource;

	@Transactional("targetTransactionManager")
	public void start() {

		// see also info.pptx

		// 1 jhi_user
		migrate(createTabelMapping_jhi_user());
		// 2 jhi_user_authority
		migrate(createTabelMapping_jhi_user_authority());
		// 3 institution
		migrate(createTabelMapping_institution());
		// 4 litho_user
		migrate(createTabelMapping_litho_user());
		// 5 litho_request
		// migrate(createTabelMapping_litho_request());
		// 6 basket
		migrate(createTabelMapping_basket());
		// 7 data_package
		migrate(createTabelMapping_data_package());
		// 8 basket_data_package
		migrate(createTabelMapping_basket_data_package());
		// 9 community
		migrate(createTabelMapping_community());
		// 10 instition_community
		migrate(createTabelMapping_institution_community());

	}

	private TableMapping createTabelMapping_institution_community() {

		TableMapping tableMapping = new TableMapping("institution_community", "institution_community");

		tableMapping.addAttribMapping("community_id", "community_id", MAPPING_TYPE.NUMBER, true);

		tableMapping.addAttribMapping("institution_id", "institution_id", MAPPING_TYPE.NUMBER, true);

		return tableMapping;
	}

	private TableMapping createTabelMapping_community() {
		TableMapping tableMapping = new TableMapping("community", "community");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);

		tableMapping.addAttribMapping("name", "name", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("description", "description", MAPPING_TYPE.STRING);

		return tableMapping;
	}

	private TableMapping createTabelMapping_basket_data_package() {

		TableMapping tableMapping = new TableMapping("basket_data_package", "basket_data_package");

		tableMapping.addAttribMapping("data_package_id", "data_package_id", MAPPING_TYPE.NUMBER, true);

		tableMapping.addAttribMapping("basket_id", "basket_id", MAPPING_TYPE.NUMBER, true);

		return tableMapping;
	}

	private TableMapping createTabelMapping_data_package() {
		TableMapping tableMapping = new TableMapping("data_package", "data_package");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);

		tableMapping.addAttribMapping("name", "name", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("distribution", "distribution", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("workflow_state", "workflow_state", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("describtion", "describtion", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("license_text", "license_text", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("price", "price", MAPPING_TYPE.NUMBER);

		tableMapping.addAttribMapping("institution_id", "institution_id", MAPPING_TYPE.NUMBER);

		return tableMapping;
	}

	private TableMapping createTabelMapping_basket() {
		TableMapping tableMapping = new TableMapping("basket", "basket");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);

		tableMapping.addAttribMapping("name", "name", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("basket_state", "basket_state", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("price", "price", MAPPING_TYPE.NUMBER);

		tableMapping.addAttribMapping("purchase_protocol", "purchase_protocol", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("creator_id", "creator_id", MAPPING_TYPE.NUMBER);

		tableMapping.addAttribMapping("institution_id", "institution_id", MAPPING_TYPE.NUMBER);

		return tableMapping;
	}

	private TableMapping createTabelMapping_litho_request() {

		TableMapping tableMapping = new TableMapping("litho_request", "litho_request");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);

		tableMapping.addAttribMapping("req_timestamp", "req_timestamp", MAPPING_TYPE.TIMESTAMP);

		tableMapping.addAttribMapping("req_method", "req_method", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("req_uri", "req_uri", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("req_query", "req_query", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("req_remote_ip", "req_remote_ip", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("req_remote_addr", "req_remote_addr", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("req_protocol", "req_protocol", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("req_args", "req_args", MAPPING_TYPE.STRING);

		tableMapping.addAttribMapping("litho_user_id", "litho_user_id", MAPPING_TYPE.NUMBER);

		return tableMapping;
	}

	private TableMapping createTabelMapping_litho_user() {
		TableMapping tableMapping = new TableMapping("litho_user", "litho_user");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);
		tableMapping.addAttribMapping("user_id", "user_id", MAPPING_TYPE.NUMBER);
		tableMapping.addAttribMapping("institution_id", "institution_id", MAPPING_TYPE.NUMBER);

		return tableMapping;
	}

	private TableMapping createTabelMapping_institution() {
		TableMapping tableMapping = new TableMapping("institution", "institution");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);
		tableMapping.addAttribMapping("name", "name", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("description", "description", MAPPING_TYPE.STRING);

		return tableMapping;
	}

	private TableMapping createTabelMapping_jhi_user_authority() {

		TableMapping tableMapping = new TableMapping("jhi_user_authority", "jhi_user_authority");

		tableMapping.addAttribMapping("user_id", "user_id", MAPPING_TYPE.NUMBER, true);
		tableMapping.addAttribMapping("authority_name", "authority_name", MAPPING_TYPE.STRING, true);

		return tableMapping;
	}

	private TableMapping createTabelMapping_jhi_user() {

		TableMapping tableMapping = new TableMapping("jhi_user", "jhi_user");

		tableMapping.addAttribMapping("id", "id", MAPPING_TYPE.NUMBER, true);
		tableMapping.addAttribMapping("login", "login", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("password_hash", "password_hash", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("first_name", "first_name", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("last_name", "last_name", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("email", "email", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("image_url", "image_url", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("activated", "activated", MAPPING_TYPE.BOOLEAN);
		tableMapping.addAttribMapping("lang_key", "lang_key", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("activation_key", "activation_key", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("reset_key", "reset_key", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("created_by", "created_by", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("created_date", "created_date", MAPPING_TYPE.TIMESTAMP);
		tableMapping.addAttribMapping("reset_date", "reset_date", MAPPING_TYPE.TIMESTAMP);
		tableMapping.addAttribMapping("last_modified_by", "last_modified_by", MAPPING_TYPE.STRING);
		tableMapping.addAttribMapping("last_modified_date", "last_modified_date", MAPPING_TYPE.TIMESTAMP);

		return tableMapping;
	}

	private void migrate(TableMapping tableMapping) {

		migrate(tableMapping, false);

	}

	private void migrate(TableMapping tableMapping, boolean deleteExistingEntries) {
		String selectAll = TableMapping.getSELECTAll(tableMapping);
		System.out.println(selectAll);
		Query selectAllQuery = emSource.createNativeQuery(selectAll);

		for (Object[] result : (List<Object[]>) selectAllQuery.getResultList()) {

			String selectById = TableMapping.getSELECTById(tableMapping, result);
			System.out.println(selectById);
			if (!emTarget.createNativeQuery(selectById).getResultList().isEmpty()) {
				if (deleteExistingEntries) {

					System.out.println("deleting existing entry");

					String delete = TableMapping.getDELETEById(tableMapping, result);

					System.out.println(delete);

					emTarget.createNativeQuery(delete).executeUpdate();

				} else {

					System.out.println("skipping existing entry");
					continue;

				}

			}

			String insert = TableMapping.getINSERT(tableMapping, result);

			System.out.println(insert);

			emTarget.createNativeQuery(insert).executeUpdate();

		}
	}

}