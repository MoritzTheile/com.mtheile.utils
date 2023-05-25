import * as React from 'react';
import { FC } from 'react';
import { Resource } from 'react-admin';
import resources from 'app/litho-ui/mydata/resources/resources';
import { EntityConfigInterface } from 'app/litho-ui/mydata/resources/_shared/EntityConfigInterface';
import { composeEntityRAList } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityRAList';
import { composeEntityRAEdit } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityRAEdit';
import { composeEntityPickerPlus, EntityPickerPlusProps } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityPickerPlus';
import { composeEntityPicker, EntityPickerProps } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityPicker';
import { composeEntityEditDialog, EntityEditDialogProps } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityEditDialog';
import {
  composeEntityCreateDialog,
  EntityCreateDialogProps
} from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityCreateDialog';
import { composeEntityRACreate } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityRACreate';
import { composeEntityFields } from './EntityFields';
import { entityColumnArray } from './EntityColumns';
import { composeEntityListRenderer } from './renderer/EntityListRenderer';
import { composeEntityRAFilter } from 'app/litho-ui/mydata/resources/_shared/composer/ComposeEntityRAFilter';

function getEntity2Shortname() {
  return entity => (entity ? entity.name : '');
}

export const entityConfig: EntityConfigInterface = {
  entityResourceName: 'MODELNAME_LOWERCASE_TOKEN/ENTITYNAME_TOKEN',
  entityLabel: 'ENTITYNAME_TOKEN',
  // batchEditorName: '',
  entity2Shortname: getEntity2Shortname(),
  string2filter: q => ({ name: q }),
  entityListRenderer: composeEntityListRenderer(getEntity2Shortname())
};

export const EntityRAFilterENTITYNAME_TOKEN = composeEntityRAFilter(entityConfig);

export const ENTITYNAME_TOKENRAResource = (
  <Resource
    name={entityConfig.entityResourceName}
    list={composeEntityRAList(entityConfig, entityColumnArray)}
    edit={composeEntityRAEdit(entityConfig, composeEntityFields(false))}
    create={composeEntityRACreate(entityConfig, composeEntityFields(true))}
  />
);

export const EntityPickerENTITYNAME_TOKEN: FC<EntityPickerProps> = composeEntityPicker(entityConfig);

export const EntityEditDialogENTITYNAME_TOKEN: FC<EntityEditDialogProps> = composeEntityEditDialog(entityConfig, composeEntityFields(false));

export const EntityCreateDialogENTITYNAME_TOKEN: FC<EntityCreateDialogProps> = composeEntityCreateDialog(entityConfig, composeEntityFields(true));

export const EntityPickerPlusENTITYNAME_TOKEN: FC<EntityPickerPlusProps> = composeEntityPickerPlus(
  entityConfig,
  EntityPickerENTITYNAME_TOKEN,
  EntityEditDialogENTITYNAME_TOKEN,
  EntityCreateDialogENTITYNAME_TOKEN
);
