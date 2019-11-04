CREATE TABLE `tb_usuario` (
  `usuario_id` bigint(20) NOT NULL,
  `usuario_nome` varchar(255) NOT NULL,
  `usuario_cpf` varchar(11) NOT NULL UNIQUE,
  `usuario_sexo` enum('masculino','feminino') NOT NULL,
  `usuario_data_nascimento` datetime NOT NULL,
  `cargo_id` bigint(20) NOT NULL,
  `perfil_id` bigint(20) NOT NULL,
  `usuario_data_atualizacao` datetime NOT NULL,
  `usuario_data_criacao` datetime NOT NULL,
  `usuario_status` enum('ativo','inativo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_cargo` (
  `cargo_id` bigint(20) NOT NULL,
  `cargo_nome` varchar(255) NOT NULL,
  `cargo_descricao` varchar(255) NOT NULL UNIQUE,
  `cargo_data_atualizacao` datetime NOT NULL,
  `cargo_data_criacao` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_perfil` (
  `perfil_id` bigint(20) NOT NULL,
  `perfil_nome` varchar(255) NOT NULL,
  `perfil_descricao` varchar(255) NOT NULL UNIQUE,
  `perfil_data_atualizacao` datetime NOT NULL,
  `perfil_data_criacao` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- Indexes for table `tb_cargo`
--
ALTER TABLE `tb_cargo`
  ADD PRIMARY KEY (`cargo_id`);

--
-- Indexes for table `tb_perfil`
--
ALTER TABLE `tb_perfil`
  ADD PRIMARY KEY (`perfil_id`);

--
-- AUTO_INCREMENT for table `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `usuario_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_cargo`
--
ALTER TABLE `tb_cargo`
  MODIFY `cargo_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lancamento`
--
ALTER TABLE `tb_perfil`
  MODIFY `perfil_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `usuario_cargo_fk` FOREIGN KEY (`cargo_id`) REFERENCES `tb_cargo` (`cargo_id`);

--
-- Constraints for table `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `usuario_perfil_fk` FOREIGN KEY (`perfil_id`) REFERENCES `tb_perfil` (`perfil_id`);
